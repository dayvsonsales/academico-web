package controller.producao;

import controller.ControllerBase;
import model.producao.Projeto;
import model.producao.Publicacao;
import repository.ProjetoRepository;
import repository.PublicacaoRepository;

import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Jose_Augusto on 24/03/2017.
 */
public class ProjetoController extends ControllerBase {

    public ProjetoController(FacesContext context) {
        super(context);
    }




    private Integer projetoId;
    private Projeto projeto;
    private ProjetoRepository repo;
    private List<Projeto> projetos;

    public ProjetoController() {
        super(FacesContext.getCurrentInstance());

        this.repo = new ProjetoRepository(ProjetoRepository.class);
        // this.monitores = this.repo.all();
    }

    public void init() {
        if (this.projetoId == null) {
            novo();
            this.setTitulo("Novo Projeto");
        } else {
            this.setTitulo("Editar Projeto");
            this.projeto = (Projeto) repo.find(projetoId);
        }
    }

    public String salvar() {
        if (repo.save(projeto) == null) {
            setParamAlert("err-add");
        } else {
            setParamAlert("ok-add");
        }
        return "/projeto/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Projeto projeto) {
        if (repo.destroy(projeto)) {
            setParamAlert("ok-del");
        } else {
            setParamAlert("err-del");
        }
        projetos.remove(projeto);
        return "/projeto/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Integer getProjetoIdId() {
        return projetoId;
    }

    public void setProjetoId(Integer projetoId) {
        this.projetoId = projetoId;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setPublicacao(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    private void novo() {
        this.projeto = new Projeto();
    }



}
