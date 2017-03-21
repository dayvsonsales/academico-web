package controller.instituicional;

import controller.Controller;
import model.instituicional.Discente;
import model.Permissoes;
import repository.DiscenteRepository;
import util.SessionUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class DiscenteController extends Controller {

    private Integer discenteId;
    private Discente discente;
    private DiscenteRepository repo;
    private ArrayList<Discente> discentes;

    public DiscenteController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new DiscenteRepository(Discente.class);
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

    public void remover(Discente discente){
        repo.destroy(discente);
        discentes.remove(discente);
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
