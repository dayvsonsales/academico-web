package model.producao;

import model.instituicional.Discente;
import model.instituicional.Docente;

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

    String descricao;
    String tipo; //Tipo de projeto
    List<Discente> integrantes;
    List<Docente> orientadores;
    List <Publicacao> publicacoes;
    String financiador;
    String linhaDePesquisa;
    String titulo;
    Date dataDeInicio;
    Date datadeTermino;




    @NotNull
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Discente> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Discente> integrantes) {
        this.integrantes = integrantes;
    }

    @OneToMany (cascade=CascadeType.ALL)
    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Docente> getOrientadores() {
        return orientadores;
    }

    public void setOrientadores(List<Docente> orientadores) {
        this.orientadores = orientadores;
    }

    public String getFinanciador() {
        return financiador;
    }

    public void setFinanciador(String financiador) {
        this.financiador = financiador;
    }

    public String getLinhaDePesquisa() {
        return linhaDePesquisa;
    }

    public void setLinhaDePesquisa(String linhaDePesquisa) {
        this.linhaDePesquisa = linhaDePesquisa;
    }

    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(Date dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public Date getDatadeTermino() {
        return datadeTermino;
    }

    public void setDatadeTermino(Date datadeTermino) {
        this.datadeTermino = datadeTermino;
    }

    @NotNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private Integer id;

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
