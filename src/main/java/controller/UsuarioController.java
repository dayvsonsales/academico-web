package controller;

import model.PermissoesEnum;
import model.Usuario;
import repository.UsuarioRepository;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by anderson on 14/03/17.
 */
@ManagedBean
@ViewScoped
public class UsuarioController extends Controller {

    private Usuario usuario;
    private UsuarioRepository repo;

    private final PermissoesEnum[] permissoesDisponiveis = PermissoesEnum.values();

    public UsuarioController() {
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

    public PermissoesEnum[] getPermissoesDisponiveis() {
        return permissoesDisponiveis;
    }
}
