package model.producao;

import model.instituicional.Discente;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jose_Augusto on 24/03/2017.
 */


@Entity
public class Publicacao {
    private Integer id;
    private String  title;
    private String abstract_;
    private String revista;
    private List<String> palavrasChaveList;
    private List<Discente> autores;
    private String financiador;
    private Date dataDeSubmissao;
    private Date dataDePublicacao;

    public Publicacao() {
        this.palavrasChaveList = new ArrayList<String>();
        this.autores = new ArrayList<Discente>();
    }

    @ManyToMany(cascade=CascadeType.ALL)
    public List<Discente> getAutores() {
        return autores;
    }


    public String getPalavrasChave(){
        String palavras= new String();
        for(String str:palavrasChaveList){
           palavras= palavras.concat(str+" ");
        }
        return palavras;
    }

    public void setPalavrasChave(String string){
        String[] paravras=string.split(" ");
        for(String str:paravras){
            palavrasChaveList.add(str);
        }
    }


    public void setAutores(List<Discente> autores) {
        this.autores = autores;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract_() {
        return abstract_;
    }

    public void setAbstract_(String abstract_) {
        this.abstract_ = abstract_;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publicacao that = (Publicacao) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
