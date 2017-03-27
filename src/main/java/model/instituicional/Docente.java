package model.instituicional;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Dayvson on 13/03/2017.
 */
@Entity
public class Docente extends Servidor {

    private Integer id;

    private ClasseDocente classe;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClasseDocente getClasse() {
        return classe;
    }

    public void setClasse(ClasseDocente classe) {
        this.classe = classe;
    }
}
