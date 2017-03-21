package model.centroacademico;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dayvson on 19/03/2017.
 */
@Entity
public class CAAtividade implements Serializable {
    private Integer id;
    private String local;
    private Date data;
    private String assunto;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @NotNull
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @NotBlank
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
