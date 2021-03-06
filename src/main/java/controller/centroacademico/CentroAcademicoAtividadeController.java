package controller.centroacademico;

import controller.ControllerBase;
import model.Permissoes;
import model.centroacademico.CAAtividade;
import model.centroacademico.Membro;
import repository.CentroAcademicoAtividadeRepository;
import repository.MembroRepository;
import util.EmailUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Dayvson on 20/03/2017.
 */
@ManagedBean
@ViewScoped
public class CentroAcademicoAtividadeController extends ControllerBase {
    private Integer centroAcademicoAtividadeId;
    private CAAtividade centroAcademicoAtividade;
    private CentroAcademicoAtividadeRepository repo;
    private ArrayList<CAAtividade> centroAcademicoAtividades;
    private boolean enviarEmail;

    public CentroAcademicoAtividadeController(){
        super(FacesContext.getCurrentInstance());
        setPermissoes(Arrays.asList(Permissoes.CENTRO_ACADEMICO));

        this.repo = new CentroAcademicoAtividadeRepository();
        this.centroAcademicoAtividades = (ArrayList<CAAtividade>) this.repo.all();
    }

    public void init() {
        if(this.centroAcademicoAtividadeId == null){
            novo();
            this.setTitulo("Nova Atividade");
        }else {
            this.setTitulo("Editar Atividade");
            this.centroAcademicoAtividade = (CAAtividade) repo.find(centroAcademicoAtividadeId);
        }
    }

    public void novo(){
        this.centroAcademicoAtividade = new CAAtividade();
    }

    public String salvar(){
        if(repo.save(centroAcademicoAtividade) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
            if(this.isEnviarEmail()){
                MembroRepository membroRepository = new MembroRepository();
                String mensagem = "Uma nova atividade foi marcada para " + new SimpleDateFormat("dd/mm/yyyy").format(centroAcademicoAtividade.getData()) + " no local" + centroAcademicoAtividade.getLocal();
                ArrayList<Membro> membros = (ArrayList<Membro>) membroRepository.all();
                for(Membro membro : membros){
                    EmailUtils.enviarMensagem(mensagem, centroAcademicoAtividade.getAssunto(), membro.getEmail());
                }
            }
        }
        return "/caatividade/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(CAAtividade centroAcademicoAtividade){
        if(repo.destroy(centroAcademicoAtividade)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        centroAcademicoAtividades.remove(centroAcademicoAtividade);
        return "/caatividade/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Integer getCentroAcademicoAtividadeId() {
        return centroAcademicoAtividadeId;
    }

    public void setCentroAcademicoAtividadeId(Integer centroAcademicoAtividadeId) {
        this.centroAcademicoAtividadeId = centroAcademicoAtividadeId;
    }

    public CAAtividade getCentroAcademicoAtividade() {
        return centroAcademicoAtividade;
    }

    public void setCentroAcademicoAtividade(CAAtividade centroAcademicoAtividade) {
        this.centroAcademicoAtividade = centroAcademicoAtividade;
    }

    public ArrayList<CAAtividade> getCentroAcademicoAtividades() {
        return centroAcademicoAtividades;
    }

    public void setCentroAcademicoAtividades(ArrayList<CAAtividade> centroAcademicoAtividades) {
        this.centroAcademicoAtividades = centroAcademicoAtividades;
    }

    public boolean isEnviarEmail() {
        return enviarEmail;
    }

    public void setEnviarEmail(boolean enviarEmail) {
        this.enviarEmail = enviarEmail;
    }
}
