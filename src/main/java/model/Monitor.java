package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dayvson on 12/03/2017.
 */
@Entity
public class Monitor {

    private Integer id;
    private String nome;

    private List<Monitoria> monitorias;

    @ManyToMany(mappedBy = "monitores")
    public List<Monitoria> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<Monitoria> monitorias) {
        this.monitorias = monitorias;
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
}
