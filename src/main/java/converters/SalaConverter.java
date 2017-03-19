package converters;

import model.patrimonio.Sala;
import repository.SalaRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "salaConverter", forClass = Sala.class)
public class SalaConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Sala sala;

        try {
            sala = (Sala) new SalaRepository(Sala.class).find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Sala");
        }

        return sala;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Sala sala = (Sala) o;
            value = sala.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Sala");
        }

        return value;
    }
}
