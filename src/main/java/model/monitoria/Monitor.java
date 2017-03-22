package model.monitoria;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Dayvson on 12/03/2017.
 */
@Entity
public class Monitor {

    private Integer id;
    private String nome;

    private List<Monitoria> monitorias;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToMany(mappedBy = "monitores")
    public List<Monitoria> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<Monitoria> monitorias) {
        this.monitorias = monitorias;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
