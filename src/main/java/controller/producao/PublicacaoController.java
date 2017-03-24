package controller.producao;

import controller.ControllerBase;

import model.producao.Publicacao;

import repository.PublicacaoRepository;

import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Jose_Augusto on 24/03/2017.
 */
public class PublicacaoController extends ControllerBase {

    private Integer publicacaoId;
    private Publicacao publicacao;
    private PublicacaoRepository repo;
    private List<Publicacao> publicacoes;

    public PublicacaoController() {
        super(FacesContext.getCurrentInstance());

        this.repo = new PublicacaoRepository(Publicacao.class);
       // this.monitores = this.repo.all();
    }

    public void init() {
        if (this.publicacaoId == null) {
            novo();
            this.setTitulo("Nova Publicação");
        } else {
            this.setTitulo("Editar Publicação");
            this.publicacao = (Publicacao) repo.find(publicacaoId);
        }
    }

    public String salvar() {
        if (repo.save(publicacao) == null) {
            setParamAlert("err-add");
        } else {
            setParamAlert("ok-add");
        }
        return "/monitor/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Publicacao publicacao) {
        if (repo.destroy(publicacao)) {
            setParamAlert("ok-del");
        } else {
            setParamAlert("err-del");
        }
        publicacoes.remove(publicacao);
        return "/publicacao/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Integer getPublicacaoId() {
        return publicacaoId;
    }

    public void setPublicacaoId(Integer publicacaoId) {
        this.publicacaoId = publicacaoId;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    private void novo() {
        this.publicacao = new Publicacao();
    }


}
