package controller.patrimonio;

import controller.Controller;
import model.patrimonio.Bloco;
import repository.BlocoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

/**
 * Created by Dayvson on 18/03/2017.
 */
@ManagedBean
@ViewScoped
public class BlocoController extends Controller {

    private Integer blocoId;
    private Bloco bloco;
    private BlocoRepository repo;
    private ArrayList<Bloco> blocos;

    public BlocoController(){
        this.repo = new BlocoRepository(Bloco.class);
        this.blocos = (ArrayList<Bloco>) this.repo.all();
    }

    public void init() {
        if(this.blocoId == null){
            novo();
            this.setTitulo("Novo Bloco");
        }else {
            this.setTitulo("Editar Bloco");
            this.bloco = (Bloco) repo.find(blocoId);
        }
    }

    public void novo(){
        this.bloco = new Bloco();
    }

    public String salvar(){
        repo.save(bloco);
        return "/bloco/index?faces-redirect=true";
    }

    public void remover(Bloco bloco){
        repo.destroy(bloco);
        blocos.remove(bloco);
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public ArrayList<Bloco> getBlocos() {
        return blocos;
    }

    public void setBlocos(ArrayList<Bloco> blocos) {
        this.blocos = blocos;
    }

    public Integer getBlocoId() {
        return blocoId;
    }

    public void setBlocoId(Integer blocoId) {
        this.blocoId = blocoId;
    }
}