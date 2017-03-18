package controller;

import model.Disciplina;
import model.Permissoes;
import repository.DisciplinaRepository;
import util.SessionUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Dayvson on 12/03/2017.
 */

@ManagedBean
@ViewScoped
public class DisciplinaController extends Controller {

    private String titulo;
    private Integer disciplinaId;
    private Disciplina disciplina;
    private DisciplinaRepository repo;
    private ArrayList<Disciplina> disciplinas;

    public DisciplinaController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new DisciplinaRepository(Disciplina.class);
        this.disciplinas = (ArrayList) repo.all();
    }

    public void init(){

        if(disciplinaId == null){
            novaDisciplina();
            this.titulo = "Nova Disciplina";
        }else {
            this.titulo = "Editar Disciplina";
            this.repo = new DisciplinaRepository(Disciplina.class);
            this.disciplina = (Disciplina) repo.find(disciplinaId);
        }
    }

    public void novaDisciplina() {
        this.disciplina = new Disciplina();
    }

    public String salvar(){
        this.repo = new DisciplinaRepository(Disciplina.class);
        repo.save(disciplina);
        return "/disciplinas/index?faces-redirect=true";
    }

    public void remover(Disciplina disciplina){
        this.repo = new DisciplinaRepository(Disciplina.class);
        repo.destroy(disciplina);
        disciplinas.remove(disciplina);
    }

    public ArrayList<Disciplina> getDisciplinas() {
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
