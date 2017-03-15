package filters;

import model.Usuario;
import util.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by anderson on 13/03/17.
 */
@WebFilter(filterName = "AutenticacaoFilter", urlPatterns = { "*.xhtml" })
public class AutenticacaoFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI();

        Usuario usuario = getUsuario(request);
        if (usuario == null) {
            if (requestURI.equals("/login.xhtml") || requestURI.equals("/usuarios/new.xhtml") || requestURI.contains("javax.faces.resource")) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect(request.getContextPath() +"/login.xhtml");
            }
        } else {
            if (requestURI.equals("/login.xhtml") || requestURI.equals("/")) {
                response.sendRedirect(request.getContextPath() +"/dashboard.xhtml");
            } else {
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException { }

    public void destroy() { }

    private Usuario getUsuario(HttpServletRequest request) {
        Usuario usuario;

        try {
            usuario = (Usuario) request.getSession(false).getAttribute("USUARIO");
        } catch (NullPointerException e) {
            usuario = null;
        }

        return usuario;
    }

}
