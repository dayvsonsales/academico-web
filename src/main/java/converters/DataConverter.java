package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "dataConverter", forClass = Date.class)
public class DataConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) return null;
        Date data;

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            data = df.parse(s);
            System.out.println(data);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Data");
        }

        return data;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Date data = (Date) o;
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            value = df.format(data);
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Data");
        }

        return value;
    }
}
