package model.patrimonio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dayvson on 18/03/2017.
 */
@Entity
public class Sala {

    private Integer id;
    private String nome;
    private String numero;
    private Bloco bloco;

    private List<Atividade> atividades;

    public Sala() {
        this.atividades = new ArrayList<Atividade>();
    }

    @OneToMany(mappedBy = "sala")
    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
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

    @ManyToOne
    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
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
