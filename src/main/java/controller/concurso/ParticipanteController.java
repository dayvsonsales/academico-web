package controller.concurso;

import controller.ControllerBase;
import model.concurso.Participante;
import repository.ParticipanteRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by anderson on 21/03/17.
 */
@ManagedBean
@ViewScoped
public class ParticipanteController extends ControllerBase {

    private Integer participanteId;
    private Participante participante;
    private List<Participante> participantes;
    private ParticipanteRepository repo;

    public ParticipanteController() {
        super(FacesContext.getCurrentInstance());
        this.repo = new ParticipanteRepository();
        this.participantes = repo.all();
    }

    public void init() {
        if(this.participanteId == null){
            novo();
            this.setTitulo("Novo Participante");
        }else {
            this.setTitulo("Editar Participante");
            this.participante = repo.find(participanteId);
        }
    }

    public String salvar(){
        if(repo.save(participante) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
        }
        return "/participante/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Participante participante){
        if (repo.destroy(participante)) {
            setParamAlert("ok-del");
        } else {
            setParamAlert("err-del");
        }

        participantes.remove(participante);
        return "/participante/index?faces-redirect=true&alert=" + getParamAlert();
    }

    private void novo() {
        this.participante = new Participante();
    }

    public Integer getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Integer participanteId) {
        this.participanteId = participanteId;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

}
