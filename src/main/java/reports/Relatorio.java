/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.IOException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Dayvson
 */
public abstract class Relatorio {

    protected JRBeanCollectionDataSource ds;
    protected String path;
    protected String relatorio;
    protected Map parametros;

    @SuppressWarnings("unchecked")
    protected void imprimirRelatorio() throws JRException, IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.responseComplete();
        System.out.println("chegou no pai");
        ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

        path = scontext.getRealPath("/WEB-INF/reports/");
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        JasperPrint impressao = JasperFillManager.fillReport(path + relatorio, parametros, ds);
        response.setContentType("application/pdf");
        byte[] bytes = JasperExportManager.exportReportToPdf(impressao);
        response.getOutputStream().write(bytes);
    }
}
