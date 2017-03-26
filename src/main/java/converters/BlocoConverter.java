package converters;

import model.patrimonio.Bloco;
import repository.BlocoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "blocoConverter", forClass = Bloco.class)
public class BlocoConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Bloco bloco;

        try {
            bloco = new BlocoRepository().find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Bloco");
        }

        return bloco;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Bloco bloco = (Bloco) o;
            value = bloco.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Bloco");
        }

        return value;
    }
}
