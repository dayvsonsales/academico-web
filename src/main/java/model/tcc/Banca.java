package model.tcc;

import model.instituicional.Servidor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by anderson on 25/03/17.
 */

@Entity
public class Banca {

    private Integer id;
    private List<Convidado> convidados;
    private List<Servidor> professores;

    public Banca() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany(mappedBy = "bancas")
    public List<Convidado> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<Convidado> convidados) {
        this.convidados = convidados;
    }

    @ManyToMany(mappedBy = "bancas")
    public List<Servidor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Servidor> professores) {
        this.professores = professores;
    }

}
