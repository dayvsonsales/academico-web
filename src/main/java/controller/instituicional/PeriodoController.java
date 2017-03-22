package controller.instituicional;

import controller.ControllerBase;
import model.instituicional.Periodo;
import repository.PeriodoRepository;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class PeriodoController extends ControllerBase {

    private Integer periodoId;
    private Periodo periodo;
    private PeriodoRepository repo;
    private ArrayList<Periodo> periodos;

    public PeriodoController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new PeriodoRepository(Periodo.class);
    }

    public void init() {
        if(this.periodoId == null){
            novo();
            this.setTitulo("Novo Periodo");
        }else {
            this.setTitulo("Editar Periodo");
            this.periodo = (Periodo) repo.find(periodoId);
        }
    }

    public void novo(){
        this.periodo = new Periodo();
    }

    public String salvar(){
        if(repo.save(periodo) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/periodo/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Periodo periodo){
        if(repo.destroy(periodo)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        periodos.remove(periodo);
        return "/periodo/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public ArrayList<Periodo> getPeriodos() {
        if(periodos == null){
            this.periodos = (ArrayList<Periodo>) this.repo.all();
        }
        return periodos;
    }

    public void setPeriodos(ArrayList<Periodo> periodos) {
        this.periodos = periodos;
    }

    public Integer getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(Integer periodoId) {
        this.periodoId = periodoId;
    }

}