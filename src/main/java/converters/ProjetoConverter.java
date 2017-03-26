package converters;

import model.concurso.Concurso;
import model.producao.Projeto;
import repository.ConcursoRepository;
import repository.ProjetoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "projetoConverter", forClass = Projeto.class)
public class ProjetoConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Projeto projeto;

        try {
            projeto = new ProjetoRepository().find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Projeto");
        }

        return projeto;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Projeto projeto = (Projeto) o;
            value = projeto.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Projeto");
        }

        return value;
    }
}
