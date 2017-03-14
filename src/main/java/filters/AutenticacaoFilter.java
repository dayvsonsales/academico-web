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
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI();

        Usuario usuario = SessionUtils.getUsuario();
        if (usuario != null
                || requestURI.indexOf("/login.xhtml") >= 0
                || requestURI.indexOf("/usuarios/new.xhtml") >= 0
                || requestURI.contains("javax.faces.resource")) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath() +"/login.xhtml");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
