package controller.centroacademico;

import controller.ControllerBase;
import model.centroacademico.Contato;
import repository.ContatoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

/**
 * Created by Dayvson on 04/04/2017.
 */
@ManagedBean
@ViewScoped
public class ContatoController extends ControllerBase {

    private Integer contatoId;
    private Contato contato;
    private ContatoRepository repo;
    private ArrayList<Contato> contatos;

    public ContatoController() {
        this.repo = new ContatoRepository();
    }

    public void init() {
        if(this.contatoId == null){
            novo();
        }else{
            this.contato = repo.find(contatoId);
        }
    }

    public void novo(){
        this.contato = new Contato();
    }

    public String salvar(){

        if(repo.save(contato) == null){
            setParamAlert("err-add");
        }else{
            setParamAlert("ok-add");
            setMessageAlert("Mensagem enviada com sucesso! Obrigado :)");
        }

        return "/contato/index?faces-redirect=true&alert=" + getParamAlert() + "&message=" + getMessageAlert();
    }

    public Integer getContatoId() {
        return contatoId;
    }

    public void setContatoId(Integer contatoId) {
        this.contatoId = contatoId;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public ArrayList<Contato> getContatos() {
        if(contatos == null){
            this.contatos = (ArrayList<Contato>) this.repo.all();
        }
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }
}
