package model.concurso;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Dayvson on 19/03/2017.
 */
@Entity
public class Concurso implements Serializable {
    private Integer id;
    private String nome;
    private String edital;
    private String areaEstudo;
    /*private Servidor supervisor;
    private Date dataTerminoInscricao;
    private Date dataConcurso;
    private Date dataInicioInscricao;*/
    private String modalidade;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
