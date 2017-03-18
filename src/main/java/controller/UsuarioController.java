package controller;

import model.Permissoes;
import model.Usuario;
import repository.UsuarioRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Arrays;

/**
 * Created by anderson on 14/03/17.
 */
@ManagedBean
@ViewScoped
public class UsuarioController extends Controller {

    private Usuario usuario;
    private UsuarioRepository repo;

    private final Permissoes[] permissoesDisponiveis = Permissoes.values();

    public UsuarioController() {
        super(FacesContext.getCurrentInstance());
        setPermissoes(Arrays.asList(Permissoes.DIRETORIO));

        this.repo = new UsuarioRepository();
    }

    public void init() {
        this.usuario = new Usuario();
    }

    public String salvarUsuario() {
        repo.save(usuario);

        return "/login?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Permissoes[] getPermissoesDisponiveis() {
        return permissoesDisponiveis;
    }

}
