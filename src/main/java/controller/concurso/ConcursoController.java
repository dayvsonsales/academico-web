package controller.concurso;

import controller.ControllerBase;
import model.concurso.Concurso;
import repository.ConcursoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by anderson on 21/03/17.
 */
@ManagedBean
@ViewScoped
public class ConcursoController extends ControllerBase {

    private Integer concursoId;
    private Concurso concurso;
    private List<Concurso> concursos;
    private ConcursoRepository repo;

    public ConcursoController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new ConcursoRepository(Concurso.class);
        this.concursos = repo.all();
    }

    public void init() {
        if(this.concursoId == null){
            novo();
            this.setTitulo("Novo Concurso");
        }else {
            this.setTitulo("Editar Concurso");
            this.concurso = repo.find(concursoId);
        }
    }

    public String salvar(){
        if(repo.save(concurso) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/concurso/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public void remover(Concurso concurso){
        repo.destroy(concurso);
        concursos.remove(concurso);
    }

    private void novo() {
        this.concurso = new Concurso();
    }

    public Integer getConcursoId() {
        return concursoId;
    }

    public void setConcursoId(Integer concursoId) {
        this.concursoId = concursoId;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public List<Concurso> getConcursos() {
        return concursos;
    }

    public void setConcursos(List<Concurso> concursos) {
        this.concursos = concursos;
    }
}
