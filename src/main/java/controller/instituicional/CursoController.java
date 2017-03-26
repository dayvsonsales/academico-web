package controller.instituicional;

import controller.ControllerBase;
import model.instituicional.Curso;
import reports.impl.RelatorioCurso;
import repository.CursoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class CursoController extends ControllerBase {

    private Integer cursoId;
    private Curso curso;
    private CursoRepository repo;
    private ArrayList<Curso> cursos;

    public CursoController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new CursoRepository(Curso.class);
        this.cursos = (ArrayList<Curso>) this.repo.all();
    }

    public void init() {
        if(this.cursoId == null){
            novo();
            this.setTitulo("Novo Curso");
        }else {
            this.setTitulo("Editar Curso");
            this.curso = (Curso) repo.find(cursoId);
        }
    }

    public void novo(){
        this.curso = new Curso();
    }

    public void relatorio(Curso curso) {
        try {
            HashMap param = new HashMap();
            param.put("FILTROS", curso.getNome());
            param.put("curso_id", curso.getId());
            new RelatorioCurso().gerarRelatorio(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String salvar(){
        if(repo.save(curso) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/curso/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Curso curso){
        if(repo.destroy(curso)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        cursos.remove(curso);
        return "/curso/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

}
