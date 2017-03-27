package controller.instituicional;

import controller.ControllerBase;
import model.instituicional.ClasseDocente;
import model.instituicional.Docente;
import model.instituicional.Servidor;
import model.instituicional.SituacaoServidor;
import repository.ServidorRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Dayvson on 13/03/2017.
 */
@ManagedBean
@ViewScoped
public class ServidorController extends ControllerBase {
    private Integer servidorId;
    private Servidor servidor;
    private ServidorRepository repo;
    private ArrayList<Servidor> servidors;

    private ClasseDocente classe;

    private SituacaoServidor situacoes[] = SituacaoServidor.values();
    private ClasseDocente classes[] = ClasseDocente.values();

    public ServidorController() {
        super(FacesContext.getCurrentInstance());

        this.repo = new ServidorRepository();
        this.servidors = (ArrayList<Servidor>) this.repo.all();
    }

    public void init() {
        if(this.servidorId == null){
            novo();
            this.setTitulo("Novo Servidor");
        }else {
            this.setTitulo("Editar Servidor");
            this.servidor = repo.find(servidorId);
        }
    }

    public void novo(){
        this.servidor = new Servidor();
    }

    public String salvar(){
        if(classe != null){
            Docente serv = clonarServidorParaDocente(servidor);
            serv.setClasse(classe);
            if(repo.save(serv) == null){
                setParamAlert("err-add");
            }else{
                setParamAlert("ok-add");
            }
        }else{
            if(repo.save(servidor) == null){
                setParamAlert("err-add");
            }else{
                setParamAlert("ok-add");
            }
        }
        return "/servidor/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Servidor servidor){
        if(repo.destroy(servidor)){
            setParamAlert("ok-del");
        }else{
            setParamAlert("err-del");
        }
        servidors.remove(servidor);
        return "/servidor/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public ArrayList<Servidor> getServidors() {
        return servidors;
    }

    public void setServidors(ArrayList<Servidor> servidors) {
        this.servidors = servidors;
    }

    public Integer getServidorId() {
        return servidorId;
    }

    public void setServidorId(Integer servidorId) {
        this.servidorId = servidorId;
    }

    public SituacaoServidor[] getSituacoes() {
        return situacoes;
    }

    public void setSituacoes(SituacaoServidor[] situacoes) {
        this.situacoes = situacoes;
    }

    public ClasseDocente[] getClasses() {
        return classes;
    }

    public void setClasses(ClasseDocente[] classes) {
        this.classes = classes;
    }

    public ClasseDocente getClasse() {
        return classe;
    }

    public void setClasse(ClasseDocente classe) {
        this.classe = classe;
    }

    private Docente clonarServidorParaDocente(Servidor servidor){
        Docente docente = new Docente();
        docente.setNome(servidor.getNome());
        docente.setCpf(servidor.getCpf());
        docente.setCargo(servidor.getCargo());
        docente.setSiape(servidor.getSiape());
        docente.setSituacao(servidor.getSituacao());
        return docente;
    }

}
