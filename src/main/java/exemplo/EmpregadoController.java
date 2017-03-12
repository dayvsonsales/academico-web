package exemplo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class EmpregadoController implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final ArrayList<Empregado> empregados
            = new ArrayList<Empregado>(Arrays.asList(
            new Empregado("João", "Marketing", 30),
            new Empregado("Roberto", "Marketing", 25),
            new Empregado("Marcos", "Vendas", 25),
            new Empregado("Carlos", "Marketing", 33),
            new Empregado("Pedro", "Desenvolvimnto", 20)
    ));


    public ArrayList<Empregado> getEmployees() {
        return empregados;
    }
}