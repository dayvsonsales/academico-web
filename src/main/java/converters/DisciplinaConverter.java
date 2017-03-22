package converters;

import model.instituicional.Curso;
import model.instituicional.Disciplina;
import repository.CursoRepository;
import repository.DisciplinaRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "disciplinaConverter", forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Disciplina disciplina;

        try {
            disciplina = (Disciplina) new DisciplinaRepository(Disciplina.class).find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Disciplina");
        }

        return disciplina;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Disciplina disciplina = (Disciplina) o;
            value = disciplina.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Disciplina");
        }

        return value;
    }
}
