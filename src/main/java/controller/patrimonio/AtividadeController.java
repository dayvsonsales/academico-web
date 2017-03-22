package controller.patrimonio;

import controller.ControllerBase;
import model.patrimonio.Atividade;
import repository.AtividadeRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 18/03/2017.
 */
@ManagedBean
@ViewScoped
public class AtividadeController extends ControllerBase {

    private Integer atividadeId;
    private Atividade atividade;
    private AtividadeRepository repo;
    private ArrayList<Atividade> atividades;

    public AtividadeController(){
        super(FacesContext.getCurrentInstance());
        this.repo = new AtividadeRepository(Atividade.class);
        this.atividades = (ArrayList<Atividade>) this.repo.all();
    }

    public void init() {
        if(this.atividadeId == null){
            novo();
            this.setTitulo("Nova Atividade");
        }else {
            this.setTitulo("Editar Atividade");
            this.atividade = (Atividade) repo.find(atividadeId);
        }
    }

    public void novo(){
        this.atividade = new Atividade();
    }

    public String salvar(){
        if(repo.save(atividade) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/atividade/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Atividade atividade){
        if(repo.destroy(atividade)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        atividades.remove(atividade);
        return "/atividade/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Integer getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Integer atividadeId) {
        this.atividadeId = atividadeId;
    }
}
