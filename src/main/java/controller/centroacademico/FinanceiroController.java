package controller.centroacademico;

import controller.Controller;
import model.centroacademico.MovimentacaoFinanceira;
import repository.FinanceiroRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 20/03/2017.
 */
@ManagedBean
@ViewScoped
public class FinanceiroController extends Controller {
    private Integer financeiroId;
    private MovimentacaoFinanceira financeiro;
    private FinanceiroRepository repo;
    private ArrayList<MovimentacaoFinanceira> movimentacoes;

    public FinanceiroController(){
        super(FacesContext.getCurrentInstance());
        this.repo = new FinanceiroRepository(MovimentacaoFinanceira.class);
        this.movimentacoes = (ArrayList<MovimentacaoFinanceira>) this.repo.all();
    }

    public void init() {
        if(this.financeiroId == null){
            novo();
            this.setTitulo("Nova Movimentação");
        }else {
            this.setTitulo("Editar Movimentação");
            this.financeiro = (MovimentacaoFinanceira) repo.find(financeiroId);
        }
    }

    public void novo(){
        this.financeiro = new MovimentacaoFinanceira();
    }

    public String salvar(){
        repo.save(financeiro);
        return "/financeiro/index?faces-redirect=true";
    }

    public void remover(MovimentacaoFinanceira financeiro){
        repo.destroy(financeiro);
        movimentacoes.remove(financeiro);
    }

    public MovimentacaoFinanceira getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(MovimentacaoFinanceira financeiro) {
        this.financeiro = financeiro;
    }

    public ArrayList<MovimentacaoFinanceira> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(ArrayList<MovimentacaoFinanceira> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Integer getFinanceiroId() {
        return financeiroId;
    }

    public void setFinanceiroId(Integer financeiroId) {
        this.financeiroId = financeiroId;
    }
}
