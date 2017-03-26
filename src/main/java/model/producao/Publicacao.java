package model.producao;

import model.instituicional.Discente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jose_Augusto on 24/03/2017.
 */

@Entity
public class Publicacao {

    private Integer id;
    private String titulo;
    private String resumo;
    private String revista;
    private String palavrasChave;
    private List<Discente> autores;
    private String financiador;
    private Date dataDeSubmissao;
    private Date dataDePublicacao;

    private Projeto projeto;

    public Publicacao() {
        this.autores = new ArrayList<Discente>();
        this.projeto = new Projeto();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Size(min=1)
    @ManyToMany(cascade=CascadeType.ALL)
    public List<Discente> getAutores() {
        return autores;
    }

    public void setAutores(List<Discente> autores) {
        this.autores = autores;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public String getFinanciador() {
        return financiador;
    }

    public void setFinanciador(String financiador) {
        this.financiador = financiador;
    }

    public Date getDataDeSubmissao() {
        return dataDeSubmissao;
    }

    public Date getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDeSubmissao(Date dataDeSubmissao) {
        this.dataDeSubmissao = dataDeSubmissao;
    }

    public void setDataDePublicacao(Date dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    @ManyToOne
    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
