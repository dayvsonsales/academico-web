package model.patrimonio;

import javax.persistence.*;

/**
 * Created by Dayvson on 18/03/2017.
 */
@Entity
@DiscriminatorValue("P")
public class PatrimonioPermanente extends Patrimonio {
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
