package converters;

import model.Periodo;
import model.PermissoesEnum;
import repository.PeriodoRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "permissaoConverter", forClass = PermissoesEnum.class)
public class PermissaoConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        PermissoesEnum permissao;

        try {
            permissao = PermissoesEnum.valueOf(s);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Periodo");
        }

        return permissao;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String valor;
        try {
            PermissoesEnum permissao = (PermissoesEnum) o;
            valor = permissao.name();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Periodo");
        }

        return valor;
    }
}
