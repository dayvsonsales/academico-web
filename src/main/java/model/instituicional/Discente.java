package model.instituicional;

import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Periodo getPeriodoIngresso() {
        return periodoIngresso;
    }

    public void setPeriodoIngresso(Periodo periodoIngresso) {
        this.periodoIngresso = periodoIngresso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
