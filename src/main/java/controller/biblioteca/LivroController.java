package controller.biblioteca;

import controller.ControllerBase;
import model.Permissoes;
import model.biblioteca.Livro;
import model.concurso.Concurso;
import repository.ConcursoRepository;
import repository.LivroRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anderson on 21/03/17.
 */
@ManagedBean
@ViewScoped
public class LivroController extends ControllerBase {

    private Integer livroId;
    private Livro livro;
    private List<Livro> livros;
    private LivroRepository repo;

    public LivroController() {
        super(FacesContext.getCurrentInstance());
        setPermissoes(Arrays.asList(Permissoes.CENTRO_ACADEMICO));
        this.repo = new LivroRepository();
        this.livros = repo.all();
    }

    public void init() {
        if(this.livroId == null){
            novo();
            this.setTitulo("Novo Livro");
        }else {
            this.setTitulo("Editar Livro");
            this.livro = repo.find(livroId);
        }
    }

    public String salvar(){
        if(repo.save(livro) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/livro/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Livro livro){
        if (repo.destroy(livro)) {
            setParamAlert("ok-del");
        } else {
            setParamAlert("err-del");
        }
        livros.remove(livro);
        return "/livro/index?faces-redirect=true&alert=" + getParamAlert();
    }

    private void novo() {
        this.livro = new Livro();
    }

    public Integer getLivroId() {
        return livroId;
    }

    public void setLivroId(Integer livroId) {
        this.livroId = livroId;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
