package controller.patrimonio;

import controller.Controller;
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
public class AtividadeController extends Controller {

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
            this.setTitulo("Novo Atividade");
        }else {
            this.setTitulo("Editar Atividade");
            this.atividade = (Atividade) repo.find(atividadeId);
        }
    }

    public void novo(){
        this.atividade = new Atividade();
    }

    public String salvar(){
        repo.save(atividade);
        return "/atividade/index?faces-redirect=true";
    }

    public void remover(Atividade atividade){
        repo.destroy(atividade);
        atividades.remove(atividade);
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
