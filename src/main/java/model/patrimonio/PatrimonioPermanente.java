package model.patrimonio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Dayvson on 18/03/2017.
 */
@Entity
@DiscriminatorValue("P")
public class PatrimonioPermanente extends Patrimonio {
}
