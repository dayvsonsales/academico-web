package controller.patrimonio;

import controller.ControllerBase;
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
public class MovimentacaoController extends ControllerBase {

    private Integer movimentacaoId;
    private Movimentacao movimentacao;
    private MovimentacaoRepository repo;
    private ArrayList<Movimentacao> movimentacoes;

    public MovimentacaoController(){
        super(FacesContext.getCurrentInstance());
        this.repo = new MovimentacaoRepository();
        this.movimentacoes = (ArrayList<Movimentacao>) this.repo.all();
    }

    public void init() {
        if(this.movimentacaoId == null){
            novo();
            this.setTitulo("Nova Movimentação");
        }else {
            this.setTitulo("Editar Movimentação");
            this.movimentacao = repo.find(movimentacaoId);
        }
    }

    public void novo(){
        this.movimentacao = new Movimentacao();
    }

    public String salvar(){
        if(repo.save(movimentacao) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/movimentacao/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Movimentacao movimentacao){
        if(repo.destroy(movimentacao)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        movimentacoes.remove(movimentacao);
        return "/movimentacao/index?faces-redirect=true&alert=" + getParamAlert();
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
