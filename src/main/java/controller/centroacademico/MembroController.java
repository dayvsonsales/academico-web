package controller.centroacademico;

import controller.ControllerBase;
import model.Permissoes;
import model.centroacademico.Membro;
import reports.impl.RelatorioMembro;
import repository.MembroRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dayvson on 20/03/2017.
 */
@ManagedBean
@ViewScoped
public class MembroController extends ControllerBase {
    private Integer membroId;
    private Membro membro;
    private MembroRepository repo;
    private List<Membro> membros;

    public MembroController() {
        super(FacesContext.getCurrentInstance());
        setPermissoes(Arrays.asList(Permissoes.CENTRO_ACADEMICO));

        this.repo = new MembroRepository();
        this.membros = this.repo.all();
    }

    public void init() {
        if (this.membroId == null) {
            novo();
            this.setTitulo("Novo Membro");
        } else {
            this.setTitulo("Editar Membro");
            this.membro = repo.find(membroId);
        }
    }

    public void novo() {
        this.membro = new Membro();
    }

    public void relatorio() {
        try {
            new RelatorioMembro().gerarRelatorio(new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String salvar() {
        if (repo.save(membro) == null) {
            setParamAlert("err-add");
        } else {
            setParamAlert("ok-add");
        }
        return "/membro/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public String remover(Membro membro) {
        if (repo.destroy(membro)) {
            setParamAlert("ok-del");
        } else {
            setParamAlert("err-del");
        }
        membros.remove(membro);
        return "/membro/index?faces-redirect=true&alert=" + getParamAlert();
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(ArrayList<Membro> membros) {
        this.membros = membros;
    }

    public Integer getMembroId() {
        return membroId;
    }

    public void setMembroId(Integer membroId) {
        this.membroId = membroId;
    }
}
