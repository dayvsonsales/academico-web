package controller.patrimonio;

import controller.Controller;
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
public class SalaController extends Controller {

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
        repo.save(sala);
        return "/sala/index?faces-redirect=true";
    }

    public void remover(Sala sala){
        repo.destroy(sala);
        salas.remove(sala);
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
