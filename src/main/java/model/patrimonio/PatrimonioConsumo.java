package model.patrimonio;

import model.instituicional.Servidor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Dayvson on 18/03/2017.
 */
@Entity
@DiscriminatorValue("C")
public class PatrimonioConsumo extends Patrimonio {

    private Integer id;
    private Servidor servidor;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
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
