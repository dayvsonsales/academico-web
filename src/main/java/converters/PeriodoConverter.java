package converters;

import model.instituicional.Periodo;
import repository.PeriodoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "periodoConverter", forClass = Periodo.class)
public class PeriodoConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Periodo periodo;

        try {
            periodo = (Periodo) new PeriodoRepository(Periodo.class).find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Periodo");
        }

        return periodo;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Periodo periodo = (Periodo) o;
            value = periodo.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Periodo");
        }

        return value;
    }
}
