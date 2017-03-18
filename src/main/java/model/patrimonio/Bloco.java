package model.patrimonio;

import javax.persistence.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dayvson on 11/03/2017.
 */
@Entity
public class Bloco implements Serializable {

    private Integer id;
    private String nome;
    private String numero;

    private List<Sala> salas;

    public Bloco(){
        this.salas = new ArrayList<Sala>();
    }

    @OneToMany(mappedBy="bloco")
    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String toString() {
        return this.nome + " " + this.numero;
    }

}
