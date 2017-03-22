package controller.patrimonio;

import controller.ControllerBase;
import model.patrimonio.Sala;
import repository.SalaRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 18/03/2017.
 */
@ManagedBean
@ViewScoped
public class SalaController extends ControllerBase {

    private Integer salaId;
    private Sala sala;
    private SalaRepository repo;
    private ArrayList<Sala> salas;

    public SalaController(){
        super(FacesContext.getCurrentInstance());
        this.repo = new SalaRepository(Sala.class);
        this.salas = (ArrayList<Sala>) this.repo.all();
    }

    public void init() {
        if(this.salaId == null){
            novo();
            this.setTitulo("Novo Sala");
        }else {
            this.setTitulo("Editar Sala");
            this.sala = (Sala) repo.find(salaId);
        }
    }

    public void novo(){
        this.sala = new Sala();
    }

    public String salvar(){
        if(repo.save(sala) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/sala/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Sala sala){
        if(repo.destroy(sala)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        salas.remove(sala);
        return "/sala/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public Integer getSalaId() {
        return salaId;
    }

    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }
}
