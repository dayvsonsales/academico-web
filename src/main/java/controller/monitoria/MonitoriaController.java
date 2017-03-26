package controller.monitoria;

import controller.ControllerBase;
import model.monitoria.Monitoria;
import repository.MonitoriaRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by anderson on 22/03/17.
 */

@ManagedBean
@ViewScoped
public class MonitoriaController extends ControllerBase {

    private Integer monitoriaId;
    private Monitoria monitoria;
    private MonitoriaRepository repo;
    private List<Monitoria> monitorias;

    public MonitoriaController() {
        super(FacesContext.getCurrentInstance());

        this.repo = new MonitoriaRepository();
        this.monitorias = this.repo.all();
    }

    public void init() {
        if (this.monitoriaId == null) {
            novo();
            this.setTitulo("Nova Monitoria");
        } else {
            this.setTitulo("Editar Monitoria");
            this.monitoria = repo.find(monitoriaId);
        }
    }

    private void novo() {
        monitoria = new Monitoria();
    }

    public String salvar() {
        if (repo.save(monitoria) == null) {
            setParamAlert("err-add");
        } else {
            setParamAlert("ok-add");
        }
        return "/monitoria/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Monitoria monitoria) {
        if (repo.destroy(monitoria)) {
            setParamAlert("ok-del");
        } else {
            setParamAlert("err-del");
        }
        monitorias.remove(monitoria);
        return "/monitoria/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Integer getMonitoriaId() {
        return monitoriaId;
    }

    public void setMonitoriaId(Integer monitoriaId) {
        this.monitoriaId = monitoriaId;
    }

    public Monitoria getMonitoria() {
        return monitoria;
    }

    public void setMonitoria(Monitoria monitoria) {
        this.monitoria = monitoria;
    }

    public List<Monitoria> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<Monitoria> monitorias) {
        this.monitorias = monitorias;
    }
}
