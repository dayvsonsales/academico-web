package controller.instituicional;

import controller.ControllerBase;
import model.instituicional.Discente;
import repository.DiscenteRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class DiscenteController extends ControllerBase {

    private Integer discenteId;
    private Discente discente;
    private DiscenteRepository repo;
    private ArrayList<Discente> discentes;

    public DiscenteController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new DiscenteRepository();
        this.discentes = (ArrayList<Discente>) this.repo.all();
    }

    public void init() {
        if(this.discenteId == null){
            novo();
            this.setTitulo("Novo Discente");
        }else {
            this.setTitulo("Editar Discente");
            this.discente = (Discente) repo.find(discenteId);
        }
    }

    public void novo(){
        this.discente = new Discente();
    }

    public String salvar(){
        if(repo.save(discente) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/discente/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Discente discente){
        if(repo.destroy(discente)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        discentes.remove(discente);
        return "/discente/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Discente getDiscente() {
        return discente;
    }

    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

    public ArrayList<Discente> getDiscentes() {
        return discentes;
    }

    public void setDiscentes(ArrayList<Discente> discentes) {
        this.discentes = discentes;
    }

    public Integer getDiscenteId() {
        return discenteId;
    }

    public void setDiscenteId(Integer discenteId) {
        this.discenteId = discenteId;
    }

}
