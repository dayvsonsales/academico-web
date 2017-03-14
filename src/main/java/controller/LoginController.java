package controller;

import model.Usuario;
import repository.UsuarioRepository;
import util.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Created by anderson on 13/03/17.
 */
@ManagedBean
@SessionScoped
public class LoginController {

    private String email;
    private String senha;
    private Usuario usuario;

    private UsuarioRepository usuarioRepo;

    public LoginController() {
        this.usuarioRepo = new UsuarioRepository();

        if (getUsuario() == null)
            this.usuario = SessionUtils.getUsuario();
    }

    public String login() {
        Usuario result = usuarioRepo.validarEmailSenha(email, senha);

        if (result == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage messagem = new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Email ou senha incorretos!");
            context.addMessage("loginForm", messagem);

            return "/login";
        } else {
            this.usuario = result;
            SessionUtils.setUsuario(result);

            return "/dashboard";
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();

        if (session != null)
            session.invalidate();

        return "/login?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
