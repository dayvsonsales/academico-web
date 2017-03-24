package model.monitoria;

import model.instituicional.Disciplina;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }




    @Size(min = 1)
    @ManyToMany(fetch = FetchType.EAGER)

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<Monitor> monitores) {
        this.monitores = monitores;
    }

}
