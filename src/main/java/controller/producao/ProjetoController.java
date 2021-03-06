package controller.producao;

import controller.ControllerBase;
import model.producao.Projeto;
import reports.impl.RelatorioProducao;
import repository.ProjetoRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jose_Augusto on 24/03/2017.
 */

@ManagedBean
@ViewScoped
public class ProjetoController extends ControllerBase {

    private Integer projetoId;
    private Projeto projeto;
    private ProjetoRepository repo;
    private List<Projeto> projetos;

    public ProjetoController() {
        super(FacesContext.getCurrentInstance());

        this.repo = new ProjetoRepository();
        this.projetos = repo.all();
    }

    public void init() {
        if (this.projetoId == null) {
            novo();
            this.setTitulo("Novo Projeto");
        } else {
            this.setTitulo("Editar Projeto");
            this.projeto = repo.find(projetoId);
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

    public void relatorio() {
        try {
            HashMap parametros = new HashMap();
            new RelatorioProducao().gerarRelatorioProjetos(parametros);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void novo() {
        this.projeto = new Projeto();
    }

    public Integer getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Integer projetoId) {
        this.projetoId = projetoId;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
