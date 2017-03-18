package controller;

import model.instituicional.Convidado;
import repository.ConvidadoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class ConvidadoController extends Controller{

    private Integer convidadoId;
    private Convidado convidado;
    private ConvidadoRepository repo;
    private ArrayList<Convidado> convidados;

    public ConvidadoController(){
        this.repo = new ConvidadoRepository(Convidado.class);
        this.convidados = (ArrayList<Convidado>) this.repo.all();
    }

    public void init() {
        if(this.convidadoId == null){
            novo();
            this.setTitulo("Novo Convidado");
        }else {
            this.setTitulo("Editar Convidado");
            this.convidado = (Convidado) repo.find(convidadoId);
        }
    }

    public void novo(){
        this.convidado = new Convidado();
    }

    public String salvar(){
        repo.save(convidado);
        return "/convidado/index?faces-redirect=true";
    }

    public void remover(Convidado convidado){
        repo.destroy(convidado);
        convidados.remove(convidado);
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public ArrayList<Convidado> getConvidados() {
        return convidados;
    }

    public void setConvidados(ArrayList<Convidado> convidados) {
        this.convidados = convidados;
    }

    public Integer getConvidadoId() {
        return convidadoId;
    }

    public void setConvidadoId(Integer convidadoId) {
        this.convidadoId = convidadoId;
    }
}
