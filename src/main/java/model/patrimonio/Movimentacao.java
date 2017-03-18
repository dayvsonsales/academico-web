package model.patrimonio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dayvson on 18/03/2017.
 */
@Entity
public class Movimentacao {

    private Integer id;
    private Sala sala;
    private List<Patrimonio> patrimonios;
    private Date data;

    @ManyToOne
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @ManyToMany
    public List<Patrimonio> getPatrimonios() {
        return patrimonios;
    }

    public void setPatrimonios(List<Patrimonio> patrimonios) {
        this.patrimonios = patrimonios;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
