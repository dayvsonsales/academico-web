package model.centroacademico;

import util.DateUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dayvson on 19/03/2017.
 */
@Entity
public class MovimentacaoFinanceira implements Serializable{
    private Integer id;
    private Double valor;
    private String justificativa;
    private Date data;

    private String dataFormatada; //TODO: Fazer isso no próprio iReport (eu esqueci como faz e to sem vontade de procurar)

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @NotNull
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public String getDataFormatada() {
        return DateUtil.getDataFormatada(this.data);
    }

    public void setDataFormatada(String dataFormatada) {
        this.dataFormatada = dataFormatada;
    }
}
