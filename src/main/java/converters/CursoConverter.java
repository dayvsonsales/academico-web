package converters;

import model.instituicional.Curso;
import repository.CursoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "cursoConverter", forClass = Curso.class)
public class CursoConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Curso curso;

        try {
            curso = (Curso) new CursoRepository(Curso.class).find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Curso");
        }

        return curso;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Curso curso = (Curso) o;
            value = curso.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Curso");
        }

        return value;
    }
}
