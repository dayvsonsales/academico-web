package model.centroacademico;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dayvson on 04/04/2017.
 */

@Entity
public class Contato {

    private Integer id;
    private Date dataHora;
    private String mensagem;

    public Contato(){
        this.dataHora = new Date();
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Column(length = 1200)
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
