package converters;

import model.concurso.Concurso;
import model.patrimonio.Bloco;
import repository.BlocoRepository;
import repository.ConcursoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "concursoConverter", forClass = Concurso.class)
public class ConcursoConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Concurso concurso;

        try {
            concurso = new ConcursoRepository(Concurso.class).find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Concurso");
        }

        return concurso;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Concurso concurso = (Concurso) o;
            value = concurso.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Concurso");
        }

        return value;
    }
}
