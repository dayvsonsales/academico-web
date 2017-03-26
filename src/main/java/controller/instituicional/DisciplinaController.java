package controller.instituicional;

import controller.ControllerBase;
import model.instituicional.Disciplina;
import repository.DisciplinaRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dayvson on 12/03/2017.
 */

@ManagedBean
@ViewScoped
public class DisciplinaController extends ControllerBase {

    private String titulo;
    private Integer disciplinaId;
    private Disciplina disciplina;
    private DisciplinaRepository repo;
    private List<Disciplina> disciplinas;

    public DisciplinaController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new DisciplinaRepository();
        this.disciplinas = repo.all();
    }

    public void init(){
        if(disciplinaId == null){
            novaDisciplina();
            this.titulo = "Nova Disciplina";
        }else {
            this.titulo = "Editar Disciplina";
            this.disciplina = repo.find(disciplinaId);
        }
    }

    public void novaDisciplina() {
        this.disciplina = new Disciplina();
    }

    public String salvar(){
        if(repo.save(disciplina) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/disciplinas/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Disciplina disciplina){
        if(repo.destroy(disciplina)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        disciplinas.remove(disciplina);
        return "/disciplinas/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
