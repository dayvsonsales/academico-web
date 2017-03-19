package controller.patrimonio;

import controller.Controller;
import model.patrimonio.Movimentacao;
import repository.MovimentacaoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 18/03/2017.
 */
@ManagedBean
@ViewScoped
public class MovimentacaoController extends Controller {

    private Integer movimentacaoId;
    private Movimentacao movimentacao;
    private MovimentacaoRepository repo;
    private ArrayList<Movimentacao> movimentacoes;

    public MovimentacaoController(){
        super(FacesContext.getCurrentInstance());
        this.repo = new MovimentacaoRepository(Movimentacao.class);
        this.movimentacoes = (ArrayList<Movimentacao>) this.repo.all();
    }

    public void init() {
        if(this.movimentacaoId == null){
            novo();
            this.setTitulo("Nova Movimentação");
        }else {
            this.setTitulo("Editar Movimentação");
            this.movimentacao = (Movimentacao) repo.find(movimentacaoId);
        }
    }

    public void novo(){
        this.movimentacao = new Movimentacao();
    }

    public String salvar(){
        repo.save(movimentacao);
        return "/movimentacao/index?faces-redirect=true";
    }

    public void remover(Movimentacao movimentacao){
        repo.destroy(movimentacao);
        movimentacoes.remove(movimentacao);
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public ArrayList<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Integer getMovimentacaoId() {
        return movimentacaoId;
    }

    public void setMovimentacaoId(Integer movimentacaoId) {
        this.movimentacaoId = movimentacaoId;
    }
}