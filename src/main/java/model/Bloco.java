package model;

import javax.persistence.*;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Dayvson on 11/03/2017.
 */
@Entity
public class Bloco implements Serializable {

    private Integer id;
    private String nome;
    private String numero;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString(){
        return this.nome + " " + this.numero;
    }

}
