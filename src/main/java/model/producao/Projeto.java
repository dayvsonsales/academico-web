package model.producao;

import model.instituicional.Discente;
import model.instituicional.Servidor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jose_Augusto on 24/03/2017.
 */
@Entity
public class Projeto {

    private Integer id;
    private String titulo;
    private String descricao;
    private String tipo;
    private String financiador;
    private String linhaDePesquisa;
    private Date dataInicio;
    private Date dataTermino;

    private List<Discente> integrantes;
    private List<Servidor> orientadores;
    private List <Publicacao> publicacoes;

    public Projeto() {
        this.integrantes = new ArrayList<Discente>();
        this.orientadores = new ArrayList<Servidor>();
        this.publicacoes = new ArrayList<Publicacao>();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @NotNull
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    public List<Discente> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Discente> integrantes) {
        this.integrantes = integrantes;
    }

    @OneToMany (cascade=CascadeType.MERGE)
    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    public List<Servidor> getOrientadores() {
        return orientadores;
    }

    public void setOrientadores(List<Servidor> orientadores) {
        this.orientadores = orientadores;
    }

    @NotBlank
    public String getFinanciador() {
        return financiador;
    }

    public void setFinanciador(String financiador) {
        this.financiador = financiador;
    }

    @NotBlank
    public String getLinhaDePesquisa() {
        return linhaDePesquisa;
    }

    public void setLinhaDePesquisa(String linhaDePesquisa) {
        this.linhaDePesquisa = linhaDePesquisa;
    }

    @NotNull
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @NotNull
    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    @NotBlank
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Projeto other = (Projeto) obj;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
