package controller.patrimonio;

import controller.ControllerBase;
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
import java.util.List;

/**
 * Created by Dayvson on 18/03/2017.
 */
@ManagedBean
@ViewScoped
public class PatrimonioController extends ControllerBase {

    private boolean detalhes;
    private Integer patrimonioId;
    private Patrimonio patrimonio;
    private PatrimonioRepository repo;
    private List<Patrimonio> patrimonios;
    private Status[] status = Status.values();
    private String tipo;
    private Servidor servidor;


    public PatrimonioController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new PatrimonioRepository();
        this.servidor = new Servidor();
        this.patrimonios = this.repo.all();
    }

    public void init() {
        if (this.patrimonioId == null) {
            novo();
            this.setTitulo("Novo Patrimonio");
        } else if (detalhes) {
            this.setTitulo("Detalhes Patrimonio");
            this.patrimonio = repo.find(patrimonioId);
        } else {
            this.setTitulo("Editar Patrimonio");
            this.patrimonio = repo.find(patrimonioId);
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
            ((PatrimonioConsumo) this.patrimonio).setServidor(servidor);
        }
        if(repo.save(patrimonio) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/patrimonio/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Patrimonio patrimonio) {
        if(repo.destroy(patrimonio)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        patrimonios.remove(patrimonio);
        return "/patrimonio/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Patrimonio getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Patrimonio patrimonio) {
        this.patrimonio = patrimonio;
    }

    public List<Patrimonio> getPatrimonios() {
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
