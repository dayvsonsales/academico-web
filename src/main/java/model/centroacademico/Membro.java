package model.centroacademico;

import model.instituicional.Curso;
import model.instituicional.Periodo;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Dayvson on 19/03/2017.
 */
@Entity
public class Membro implements Serializable {

    private Integer id;
    private String nome;
    private String matricula;
    private Curso curso;
    private Periodo periodoIngresso;
    private String cargo;
    private String email;

    @NotBlank
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotBlank
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @ManyToOne
    @NotNull
    public Periodo getPeriodoIngresso() {
        return periodoIngresso;
    }

    public void setPeriodoIngresso(Periodo periodoIngresso) {
        this.periodoIngresso = periodoIngresso;
    }

    @NotBlank
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @NotBlank
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @NotNull
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
