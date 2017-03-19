package model.centroacademico;

import model.instituicional.Periodo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Dayvson on 19/03/2017.
 */
@Entity
public class Membro implements Serializable {
    private Integer id;
    private String nome;
    private String matricula;
    private String curso;
    private Periodo periodoIngresso;
    private String cargo;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @ManyToOne
    public Periodo getPeriodoIngresso() {
        return periodoIngresso;
    }

    public void setPeriodoIngresso(Periodo periodoIngresso) {
        this.periodoIngresso = periodoIngresso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
