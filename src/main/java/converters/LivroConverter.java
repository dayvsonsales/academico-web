package converters;

import model.biblioteca.Livro;
import model.concurso.Concurso;
import repository.ConcursoRepository;
import repository.LivroRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by anderson on 04/04/17.
 */
@FacesConverter(value = "livroConverter", forClass = Livro.class)
public class LivroConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Livro livro;

        try {
            livro = new LivroRepository().find(Integer.parseInt(s));
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ConverterException("Erro ao converter para objeto Livro");
        }

        return livro;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value;
        try {
            Livro livro = (Livro) o;
            value = livro.getId().toString();
        } catch (Throwable e) {
            throw new ConverterException("Erro ao converter para string Livro");
        }

        return value;
    }
}
