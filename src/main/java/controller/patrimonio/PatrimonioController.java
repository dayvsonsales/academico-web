package controller.patrimonio;

import controller.Controller;
import model.patrimonio.Patrimonio;
import model.patrimonio.PatrimonioConsumo;
import model.patrimonio.PatrimonioPermanente;
import model.patrimonio.Status;
import repository.PatrimonioRepository;
import model.instituicional.Servidor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 18/03/2017.
 */
@ManagedBean
@ViewScoped
public class PatrimonioController extends Controller {

    private boolean detalhes;
    private Integer patrimonioId;
    private Patrimonio patrimonio;
    private PatrimonioRepository repo;
    private ArrayList<Patrimonio> patrimonios;
    private Status[] status = Status.values();
    private String tipo;
    private Servidor servidor;


    public PatrimonioController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new PatrimonioRepository(Patrimonio.class);
        this.servidor = new Servidor();
        this.patrimonios = (ArrayList<Patrimonio>) this.repo.all();
    }

    public void init() {
        if (this.patrimonioId == null) {
            novo();
            this.setTitulo("Novo Patrimonio");
        } else if (detalhes) {
            this.setTitulo("Detalhes Patrimonio");
            this.patrimonio = (Patrimonio) repo.find(patrimonioId);
        } else {
            this.setTitulo("Editar Patrimonio");
            this.patrimonio = (Patrimonio) repo.find(patrimonioId);
        }
        setarTipo();
    }

    private void setarTipo() {
        if (this.patrimonio != null) {
            if (this.patrimonio instanceof PatrimonioConsumo) {
                this.tipo = "consumo";
                this.servidor = ((PatrimonioConsumo) patrimonio).getServidor();
            } else {
                this.tipo = "permanente";
            }
        }
    }

    public void novo() {
        if (tipo.equals("consumo")) {
            this.patrimonio = new PatrimonioConsumo();
        } else {
            this.patrimonio = new PatrimonioPermanente();
        }
    }

    public String salvar() {
        if (this.tipo.equals("consumo")) {
            System.out.println("bucetinha" + servidor.getId());
            ((PatrimonioConsumo) this.patrimonio).setServidor(servidor);
        }
        System.out.println("cu" + ((PatrimonioConsumo) this.patrimonio).getServidor().getId());
        repo.save(patrimonio);
        return "/patrimonio/index?faces-redirect=true";
    }

    public void remover(Patrimonio patrimonio) {
        repo.destroy(patrimonio);
        patrimonios.remove(patrimonio);
    }

    public Patrimonio getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Patrimonio patrimonio) {
        this.patrimonio = patrimonio;
    }

    public ArrayList<Patrimonio> getPatrimonios() {
        return patrimonios;
    }

    public void setPatrimonios(ArrayList<Patrimonio> patrimonios) {
        this.patrimonios = patrimonios;
    }

    public Integer getPatrimonioId() {
        return patrimonioId;
    }

    public void setPatrimonioId(Integer patrimonioId) {
        this.patrimonioId = patrimonioId;
    }

    public boolean isDetalhes() {
        return detalhes;
    }

    public void setDetalhes(boolean detalhes) {
        this.detalhes = detalhes;
    }

    public Status[] getStatus() {

        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public void setStatus(Status[] status) {
        this.status = status;
    }
}
