package controller;

import java.io.Serializable;

import model.Permissoes;
import model.Usuario;
import org.apache.commons.codec.binary.Base64;
import util.SessionUtils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by anderson on 13/03/2017.
 */
public abstract class ControllerBase implements Serializable {

    private String titulo;
    private String paramAlert;
    private String messageAlert;
    private Set<Permissoes> permissoes;
    private FacesContext context;
    private Usuario usuarioAtual;

    public ControllerBase(){}

    public ControllerBase(FacesContext context) {
        this.context = context;
        this.permissoes = new HashSet<Permissoes>(Arrays.asList(Permissoes.ADMIN));
        this.usuarioAtual = SessionUtils.getUsuario(context);
        if(usuarioAtual != null){
            verificarPermissao();
        }
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

    public List toSelectList(List list) {
        ArrayList selectList = new ArrayList(list);

        return selectList;
    }

    public void setPermissoes(List<Permissoes> permissoes) {
        this.permissoes.addAll(permissoes);

        verificarPermissao();
    }

    public void verificarPermissao() {
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

        if (!permissoes.contains(usuarioAtual.getPermissao())) {
            try {
                response.sendRedirect("/sem-permissao.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getMessageAlert() {
        if(messageAlert == null)
            return "";
        return Base64.encodeBase64String(messageAlert.getBytes());
    }

    public void setMessageAlert(String messageAlert) {
        this.messageAlert = messageAlert;
    }
}
