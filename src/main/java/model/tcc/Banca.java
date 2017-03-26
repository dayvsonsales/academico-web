package model.tcc;

import model.instituicional.Servidor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 25/03/17.
 */

@Entity
@Proxy(lazy = false)
public class Banca {

    private Integer id;
    private List<Convidado> convidados;
    private List<Servidor> professores;

    private Tcc tcc;

    public Banca() {
        convidados = new ArrayList<Convidado>();
        professores = new ArrayList<Servidor>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    public List<Convidado> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<Convidado> convidados) {
        this.convidados = convidados;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    public List<Servidor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Servidor> professores) {
        this.professores = professores;
    }

    @OneToOne
    public Tcc getTcc() {
        return tcc;
    }

    public void setTcc(Tcc tcc) {
        this.tcc = tcc;
    }
}
