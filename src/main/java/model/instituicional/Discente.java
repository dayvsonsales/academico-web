package model.instituicional;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Dayvson on 13/03/2017.
 */
@Entity
public class Discente {

    private Integer id;
    private String nome;
    private String matricula;
    private Curso curso;
    private Periodo periodoIngresso;
    private String cpf;

    public Discente() {
        this.curso = new Curso();
        this.periodoIngresso = new Periodo();
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotBlank
    @CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @NotBlank
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    public Periodo getPeriodoIngresso() {
        return periodoIngresso;
    }

    public void setPeriodoIngresso(Periodo periodoIngresso) {
        this.periodoIngresso = periodoIngresso;
    }

    @Override
    public String toString(){
        return this.matricula + " - " + this.nome;
    }
}
