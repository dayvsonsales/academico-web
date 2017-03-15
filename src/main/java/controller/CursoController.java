package controller;

import model.Curso;
import repository.CursoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class CursoController extends Controller{

    private Integer cursoId;
    private Curso curso;
    private CursoRepository repo;
    private ArrayList<Curso> cursos;

    public CursoController(){
        this.repo = new CursoRepository(Curso.class);
        this.cursos = (ArrayList<Curso>) this.repo.all();
    }

    public void init() {
        if(this.cursoId == null){
            novo();
            this.setTitulo("Novo Curso");
        }else {
            this.setTitulo("Editar Disciplina");
            this.curso = (Curso) repo.find(cursoId);
        }
    }

    public void novo(){
        this.curso = new Curso();
    }

    public String salvar(){
        repo.save(curso);
        return "/curso/index?faces-redirect=true";
    }

    public void remover(Curso curso){
        repo.destroy(curso);
        cursos.remove(curso);
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
