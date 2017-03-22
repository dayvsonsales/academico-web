package converters;

import model.instituicional.Disciplina;
import model.monitoria.Monitor;
import repository.DisciplinaRepository;
import repository.MonitorRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Dayvson on 15/03/2017.
 */
@FacesConverter(value = "monitorConverter", forClass = Monitor.class)
public class MonitorConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Monitor monitor;

        try {
            monitor = (Monitor) new MonitorRepository(Monitor.class).find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Disciplina");
        }

        return monitor;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Monitor monitor = (Monitor) o;
            value = monitor.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Disciplina");
        }

        return value;
    }
}
