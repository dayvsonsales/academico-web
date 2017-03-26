package converters;

import model.instituicional.Discente;
import model.instituicional.Disciplina;
import repository.DiscenteRepository;
import repository.DisciplinaRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by anderson on 15/03/2017.
 */
@FacesConverter(value = "discenteConverter", forClass = Discente.class)
public class DiscenteConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Discente discente;

        try {
            discente = (Discente) new DiscenteRepository().find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Discente");
        }

        return discente;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Discente discente = (Discente) o;
            value = discente.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Discente");
        }

        return value;
    }
}
