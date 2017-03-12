package exemplo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean
@SessionScoped
public class EmpregadoController implements Serializable {
    private static final long serialVersionUID = 1L;

    private Empregado empregado;

    private  ArrayList<Empregado> empregados = new ArrayList<Empregado>(Arrays.asList(
            new Empregado("João", "Marketing", 30),
            new Empregado("Roberto", "Marketing", 25),
            new Empregado("Marcos", "Vendas", 25),
            new Empregado("Carlos", "Marketing", 33),
            new Empregado("Pedro", "Desenvolvimnto", 20)
    ));


    public ArrayList<Empregado> getEmpregados() {
        return empregados;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public void novoEmpregado() {
    this.empregado = new Empregado();
    }

    public String salvarEmpregado() {
        empregados.add(empregado);
        empregado = new Empregado();

        return "/empregados/index?faces-redirect=true";
    }

    public void removerEmpregado(Empregado empregado) {
        empregados.remove(empregado);
    }
}