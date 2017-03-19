package converters;

import model.patrimonio.Patrimonio;
import repository.PatrimonioRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "patrimonioConverter", forClass = Patrimonio.class)
public class PatrimonioConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Patrimonio patrimonio;

        try {
            patrimonio = (Patrimonio) new PatrimonioRepository(Patrimonio.class).find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Patrimonio");
        }

        return patrimonio;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Patrimonio patrimonio = (Patrimonio) o;
            value = patrimonio.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Patrimonio");
        }

        return value;
    }
}
