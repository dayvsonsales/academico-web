package controller.monitoria;

import controller.ControllerBase;
import model.centroacademico.Membro;
import model.monitoria.Monitor;
import repository.MembroRepository;
import repository.MonitorRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 21/03/17.
 */

@ManagedBean
@ViewScoped
public class MonitorController extends ControllerBase {

    private Integer monitorId;
    private Monitor monitor;
    private MonitorRepository repo;
    private List<Monitor> monitores;

    public MonitorController() {
        super(FacesContext.getCurrentInstance());

        this.repo = new MonitorRepository(Monitor.class);
        this.monitores = this.repo.all();
    }

    public void init() {
        if (this.monitorId == null) {
            novo();
            this.setTitulo("Novo Monitor");
        } else {
            this.setTitulo("Editar Monitor");
            this.monitor = (Monitor) repo.find(monitorId);
        }
    }

    public String salvar() {
        if (repo.save(monitor) == null) {
            setParamAlert("err-add");
        } else {
            setParamAlert("ok-add");
        }
        return "/monitor/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Monitor monitor) {
        if (repo.destroy(monitor)) {
            setParamAlert("ok-del");
        } else {
            setParamAlert("err-del");
        }
        monitores.remove(monitor);
        return "/monitor/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Integer getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public List<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<Monitor> monitores) {
        this.monitores = monitores;
    }

    private void novo() {
        this.monitor = new Monitor();
    }
}
