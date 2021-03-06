package converters;

import model.instituicional.Servidor;
import repository.ServidorRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "servidorConverter", forClass = Servidor.class)
public class ServidorConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Servidor servidor;

        try {
            servidor = new ServidorRepository().find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Servidor");
        }

        return servidor;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Servidor servidor = (Servidor) o;
            value = servidor.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Servidor");
        }

        return value;
    }
}
