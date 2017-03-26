package model.tcc;

import model.instituicional.Curso;
import model.instituicional.Discente;
import model.instituicional.Servidor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by anderson on 25/03/17.
 */

@Entity
public class Tcc {

    private Integer id;
    private Curso curso;
    private Discente discente;
    private Servidor orientador;
    private String titulo;
    private Date dataInicio;
    private Date dataFim;

    private Banca banca;

    public Tcc() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @NotNull
    @OneToOne
    public Discente getDiscente() {
        return discente;
    }

    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

    @NotNull
    @ManyToOne
    public Servidor getOrientador() {
        return orientador;
    }

    public void setOrientador(Servidor orientador) {
        this.orientador = orientador;
    }

    @NotBlank
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @NotNull
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @NotNull
    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @OneToOne
    public Banca getBanca() {
        return banca;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }
}
