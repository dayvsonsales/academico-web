package controller;

import java.io.Serializable;

import model.Permissoes;
import model.Usuario;
import util.SessionUtils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by anderson on 13/03/2017.
 */
public abstract class Controller implements Serializable {

    private String titulo;
    private String paramAlert;
    private Set<Permissoes> permissoes;
    private FacesContext context;
    private Usuario usuarioAtual;

    public Controller(FacesContext context) {
        this.context = context;
        this.permissoes = new HashSet<Permissoes>(Arrays.asList(Permissoes.ADMIN));
        this.usuarioAtual = SessionUtils.getUsuario(context);

        verificarPermissao();
    }

    public abstract void init();

    public String getParamAlert() {
        return paramAlert;
    }

    public void setParamAlert(String paramAlert) {
        this.paramAlert = paramAlert;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPermissoes(List<Permissoes> permissoes) {
        this.permissoes.addAll(permissoes);

        verificarPermissao();
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void verificarPermissao() {
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

        if (!pode()) {
            try {
                response.sendRedirect("/sem-permissao.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean pode() {
        return permissoes.contains(usuarioAtual.getPermissao());
    }

}
