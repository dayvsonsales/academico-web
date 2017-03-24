package model.monitoria;

import model.instituicional.Disciplina;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Dayvson on 12/03/2017.
 */
@Entity
public class Monitoria {

    private Integer id;
    private Disciplina disciplina;

    private List<Monitor> monitores;

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }



    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<Monitor> monitores) {
        this.monitores = monitores;
    }

}
