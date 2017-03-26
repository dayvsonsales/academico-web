package controller.instituicional;

import controller.ControllerBase;
import model.instituicional.Discente;
import model.instituicional.Periodo;
import model.instituicional.SolicitacaoTrancamento;
import model.instituicional.StatusTrancamento;
import repository.DiscenteRepository;
import repository.PeriodoRepository;
import repository.SolicitacaoTrancamentoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

/**
 * Created by Dayvson on 26/03/2017.
 */

@ManagedBean
@ViewScoped
public class SolicitacaoTrancamentoController extends ControllerBase {

    private Integer solicitacaoTrancamentoId;
    private SolicitacaoTrancamento solicitacaoTrancamento;
    private SolicitacaoTrancamentoRepository repo;
    private ArrayList<SolicitacaoTrancamento> solicitacaoTrancamentos;
    private String matricula;

    public SolicitacaoTrancamentoController() {
        this.repo = new SolicitacaoTrancamentoRepository();
    }

    public void init() {
        if(this.solicitacaoTrancamentoId == null){
            novo();
            this.setTitulo("Nova Solicitação de Trancamento");
        }else{
            this.solicitacaoTrancamento = repo.find(solicitacaoTrancamentoId);
        }
    }

    public void novo(){
        this.solicitacaoTrancamento = new SolicitacaoTrancamento();
    }

    public String alterarStatus(String status){
        if(status.equals("APROVADO")){
            solicitacaoTrancamento.setStatusTrancamento(StatusTrancamento.APROVADO);
        } else {
            solicitacaoTrancamento.setStatusTrancamento(StatusTrancamento.NAO_APROVADO);
        }

        if(repo.save(solicitacaoTrancamento) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
            setMessageAlert("Status alterado com sucesso!");
        }
        return "/solicitacaotrancamento/list?faces-redirect=true&alert=" + getParamAlert() + "&message=" + getMessageAlert();
    }

    public String salvar(){
        PeriodoRepository periodoRepository = new PeriodoRepository();

        solicitacaoTrancamento.setPeriodoSolicitacaoTrancamento((Periodo) periodoRepository.find(1)); //TODO: alterar para ter um painal de configuração

        DiscenteRepository discenteRepository = new DiscenteRepository();
        Discente discente = discenteRepository.buscarPorMatricula(matricula);

        if(discente == null){
            setParamAlert("err-add");
            setMessageAlert("Matrícula informada é inválida. Por favor, solicite novamente!");
            return "/solicitacaotrancamento/index?faces-redirect=true&alert=" + getParamAlert() + "&message=" + getMessageAlert();
        }

        solicitacaoTrancamento.setDiscente(discente);
        solicitacaoTrancamento.setStatusTrancamento(StatusTrancamento.NAO_AVALIADO);

        if(repo.save(solicitacaoTrancamento) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
            setMessageAlert("Solicitado com sucesso! Aguarde o coordenador julgar sua solicitação!");
        }

        return "/solicitacaotrancamento/index?faces-redirect=true&alert=" + getParamAlert() + "&message=" + getMessageAlert();
    }

    public SolicitacaoTrancamento getSolicitacaoTrancamento() {
        return solicitacaoTrancamento;
    }

    public void setSolicitacaoTrancamento(SolicitacaoTrancamento solicitacaoTrancamento) {
        this.solicitacaoTrancamento = solicitacaoTrancamento;
    }

    public ArrayList<SolicitacaoTrancamento> getSolicitacaoTrancamentos() {
        if(solicitacaoTrancamentos == null){
            this.solicitacaoTrancamentos = (ArrayList<SolicitacaoTrancamento>) this.repo.all();
        }
        return solicitacaoTrancamentos;
    }

    public void setSolicitacaoTrancamentos(ArrayList<SolicitacaoTrancamento> solicitacaoTrancamentos) {
        this.solicitacaoTrancamentos = solicitacaoTrancamentos;
    }

    public Integer getSolicitacaoTrancamentoId() {
        return solicitacaoTrancamentoId;
    }

    public void setSolicitacaoTrancamentoId(Integer solicitacaoTrancamentoId) {
        this.solicitacaoTrancamentoId = solicitacaoTrancamentoId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
