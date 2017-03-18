package model.patrimonio;

import model.patrimonio.Sala;

import javax.persistence.*;

/**
 * Created by Dayvson on 18/03/2017.
 */
@Entity
public class Atividade {

    private Integer id;
    private String nome;
    private String inicio;
    private String fim;
    private Sala sala;

    @ManyToOne
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
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
