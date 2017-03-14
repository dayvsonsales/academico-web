package controller;

import model.Usuario;
import repository.UsuarioRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by anderson on 14/03/17.
 */
@ManagedBean
@ViewScoped
public class UsuarioController {

    private Usuario usuario;
    private UsuarioRepository repo;

    public UsuarioController() {
        this.repo = new UsuarioRepository();
    }

    public void init() {
        usuario = new Usuario();
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
}
