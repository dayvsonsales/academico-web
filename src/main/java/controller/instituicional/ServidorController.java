package controller.instituicional;

import controller.Controller;
import model.instituicional.Servidor;
import repository.ServidorRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class ServidorController extends Controller {
    private Integer servidorId;
    private Servidor servidor;
    private ServidorRepository repo;
    private ArrayList<Servidor> servidors;

    public ServidorController() {
        super(FacesContext.getCurrentInstance());

        this.repo = new ServidorRepository(Servidor.class);
        this.servidors = (ArrayList<Servidor>) this.repo.all();
    }

    public void init() {
        if(this.servidorId == null){
            novo();
            this.setTitulo("Novo Servidor");
        }else {
            this.setTitulo("Editar Servidor");
            this.servidor = (Servidor) repo.find(servidorId);
        }
    }

    public void novo(){
        this.servidor = new Servidor();
    }

    public String salvar(){
        System.out.println(servidor);
        repo.save(servidor);
        return "/servidor/index?faces-redirect=true";
    }

    public void remover(Servidor servidor){
        repo.destroy(servidor);
        servidors.remove(servidor);
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public ArrayList<Servidor> getServidors() {
        return servidors;
    }

    public void setServidors(ArrayList<Servidor> servidors) {
        this.servidors = servidors;
    }

    public Integer getServidorId() {
        return servidorId;
    }

    public void setServidorId(Integer servidorId) {
        this.servidorId = servidorId;
    }

}
