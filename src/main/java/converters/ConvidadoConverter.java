package converters;

import model.tcc.Convidado;
import repository.ConvidadoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by anderson on 15/03/2017.
 */
@FacesConverter(value = "convidadoConverter", forClass = Convidado.class)
public class ConvidadoConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Convidado convidado;

        try {
            convidado = new ConvidadoRepository().find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Convidado");
        }

        return convidado;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Convidado convidado = (Convidado) o;
            value = convidado.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Convidado");
        }

        return value;
    }
}
