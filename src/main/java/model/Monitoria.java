package model;

import model.instituicional.Disciplina;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dayvson on 12/03/2017.
 */
@Entity
public class Monitoria {

    private Integer id;

    private Disciplina disciplina;

    private List<Monitor> monitores;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="monitor_monitoria", joinColumns=@JoinColumn(name="monitoria_id"), inverseJoinColumns=@JoinColumn(name="monitor_id"))
    public List<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<Monitor> monitores) {
        this.monitores = monitores;
    }

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
