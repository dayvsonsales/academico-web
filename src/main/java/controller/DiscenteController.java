package controller;

import model.Discente;
import repository.DiscenteRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

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

    public DiscenteController(){
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
        System.out.println(discente);
        repo.save(discente);
        return "/discente/index?faces-redirect=true";
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
