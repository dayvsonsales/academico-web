package controller.tcc;

import controller.ControllerBase;
import model.tcc.Banca;
import model.tcc.Tcc;
import repository.BancaRepository;
import repository.TccRepository;

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
    private Banca banca;
    private TccRepository tccRepo;
    private BancaRepository bancaRepo;

    public TccController() {
        super(FacesContext.getCurrentInstance());
        this.tccRepo = new TccRepository();
        this.bancaRepo = new BancaRepository();
        this.tccs = tccRepo.all();
    }

    public void init() {
        if(this.tccId== null){
            novo();
            this.setTitulo("Novo TCC");
        }else {
            this.setTitulo("Editar TCC");
            this.tcc = tccRepo.find(tccId);
            this.banca = tcc.getBanca();
        }
    }

    private void novo() {
        this.tcc = new Tcc();
        this.banca = new Banca();
    }

    public String salvar(){
        Tcc tccSalvo = tccRepo.save(tcc);

        if(tccSalvo == null){
            setParamAlert("err-add");
        }else{
            tcc = tccSalvo;
            banca.setTcc(tcc);
            banca = bancaRepo.save(banca);

            setParamAlert("ok-add");
        }

        return "/tcc/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Tcc tcc){
        if(tccRepo.destroy(tcc)){
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

    public Banca getBanca() {
        return banca;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }
}
