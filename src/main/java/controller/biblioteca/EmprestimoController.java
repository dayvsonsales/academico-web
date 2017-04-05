package controller.biblioteca;

import controller.ControllerBase;
import model.Permissoes;
import model.biblioteca.Emprestimo;
import model.biblioteca.Livro;
import repository.EmprestimoRepository;
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
public class EmprestimoController extends ControllerBase {

    private Integer emprestimoId;
    private Emprestimo emprestimo;
    private List<Emprestimo> emprestimos;
    private EmprestimoRepository repo;

    public EmprestimoController() {
        super(FacesContext.getCurrentInstance());
        setPermissoes(Arrays.asList(Permissoes.CENTRO_ACADEMICO));
        this.repo = new EmprestimoRepository();
        this.emprestimos = repo.all();
    }

    public void init() {
        if(this.emprestimoId == null){
            novo();
            this.setTitulo("Novo Empréstimo");
        }else {
            this.setTitulo("Editar Empréstimo");
            this.emprestimo = repo.find(emprestimoId);
        }
    }

    public String salvar(){
        if(repo.save(emprestimo) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/emprestimo/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Emprestimo emprestimo){
        if (repo.destroy(emprestimo)) {
            setParamAlert("ok-del");
        } else {
            setParamAlert("err-del");
        }
        emprestimos.remove(emprestimo);
        return "/emprestimo/index?faces-redirect=true&alert=" + getParamAlert();
    }

    private void novo() {
        this.emprestimo = new Emprestimo();
    }

    public Integer getEmprestimoId() {
        return emprestimoId;
    }

    public void setEmprestimoId(Integer emprestimoId) {
        this.emprestimoId = emprestimoId;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

}
