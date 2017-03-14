package util;

import model.Usuario;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by anderson on 13/03/17.
 */
public class SessionUtils {

    public static HttpSession getSession() {
         FacesContext context = FacesContext.getCurrentInstance();

         if (context == null) return null;

        return (HttpSession) context.getExternalContext().getSession(false);
    }

    public static void setUsuario(Usuario usuario) {
        HttpSession session = getSession();

        session.setAttribute("USUARIO", usuario);
    }

    public static Usuario getUsuario() {
        HttpSession session = getSession();

        if (session == null) return null;

        Usuario usuario;
        try {
            usuario = (Usuario) session.getAttribute("USUARIO");
        } catch (NullPointerException e) {
            usuario = null;
        }

        return usuario;
    }

}
