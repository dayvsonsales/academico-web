package controller;

import model.Periodo;
import repository.PeriodoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class PeriodoController extends Controller{
    private Integer periodoId;
    private Periodo periodo;
    private PeriodoRepository repo;
    private ArrayList<Periodo> periodos;

    public PeriodoController(){
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
        repo.save(periodo);
        return "/periodo/index?faces-redirect=true";
    }

    public void remover(Periodo periodo){
        repo.destroy(periodo);
        periodos.remove(periodo);
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