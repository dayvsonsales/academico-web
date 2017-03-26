package controller.centroacademico;

import controller.ControllerBase;
import model.Meses;
import model.Permissoes;
import model.centroacademico.MovimentacaoFinanceira;
import reports.impl.RelatorioFinanceiro;
import repository.FinanceiroRepository;
import util.DateUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;

/**
 * Created by Dayvson on 20/03/2017.
 */
@ManagedBean
@ViewScoped
public class FinanceiroController extends ControllerBase {
    private Integer financeiroId;
    private MovimentacaoFinanceira financeiro;
    private FinanceiroRepository repo;
    private ArrayList<MovimentacaoFinanceira> movimentacoes;
    private Meses mes;

    private Meses[] meses = Meses.values();

    public FinanceiroController(){
        super(FacesContext.getCurrentInstance());
        setPermissoes(Arrays.asList(Permissoes.CENTRO_ACADEMICO));

        this.repo = new FinanceiroRepository(MovimentacaoFinanceira.class);
        this.movimentacoes = (ArrayList<MovimentacaoFinanceira>) this.repo.all();
    }

    public void init() {
        if(this.financeiroId == null){
            novo();
            this.setTitulo("Nova Movimentação Financeira");
        }else {
            this.setTitulo("Editar Movimentação Financeira");
            this.financeiro = (MovimentacaoFinanceira) repo.find(financeiroId);
        }
    }

    public void novo(){
        this.financeiro = new MovimentacaoFinanceira();
    }

    public void relatorio() {
        try {
            HashMap parametros = new HashMap();
            Calendar cal = Calendar.getInstance();
            parametros.put("FILTROS", DateUtil.getMesFormatado(mes.ordinal() + 1));
            parametros.put("mes", mes.ordinal() + 1);
            new RelatorioFinanceiro().gerarRelatorioFinanceiroPorMes(parametros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String salvar(){
        if(repo.save(financeiro) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/financeiro/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(MovimentacaoFinanceira financeiro){
        if(repo.destroy(financeiro)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        movimentacoes.remove(financeiro);
        return "/financeiro/index?faces-redirect=true&alert=" + getParamAlert();
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

    public Meses getMes() {
        return mes;
    }

    public void setMes(Meses mes) {
        this.mes = mes;
    }

    public Meses[] getMeses() {
        return meses;
    }

    public void setMeses(Meses[] meses) {
        this.meses = meses;
    }
}
