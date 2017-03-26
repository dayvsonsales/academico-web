package controller.tcc;

import controller.ControllerBase;
import model.tcc.Convidado;
import model.tcc.Tcc;
import repository.RepositoryBase;
import repository.TccRepo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by anderson on 25/03/17.
 */
@ManagedBean
@ViewScoped
public class TccController extends ControllerBase {

    private Integer tccId;
    private Tcc tcc;
    private List<Tcc> tccs;
    private TccRepo repo;

    public TccController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new TccRepo();
        this.tccs = repo.all();
    }

    public void init() {
        if(this.tccId== null){
            novo();
            this.setTitulo("Novo TCC");
        }else {
            this.setTitulo("Editar TCC");
            this.tcc = repo.find(tccId);
        }
    }

    private void novo() {
        this.tcc = new Tcc();
    }

    public String salvar(){
        if(repo.save(tcc) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/tcc/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Tcc tcc){
        if(repo.destroy(tcc)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        tccs.remove(tcc);

        return "/tcc/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Integer getTccId() {
        return tccId;
    }

    public void setTccId(Integer tccId) {
        this.tccId = tccId;
    }

    public Tcc getTcc() {
        return tcc;
    }

    public void setTcc(Tcc tcc) {
        this.tcc = tcc;
    }

    public List<Tcc> getTccs() {
        return tccs;
    }

    public void setTccs(List<Tcc> tccs) {
        this.tccs = tccs;
    }

}
