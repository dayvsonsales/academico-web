package model.patrimonio;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dayvson on 18/03/2017.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="patrimonio_type")
public class Patrimonio {

    private Integer id;
    private String nome;
    private String numero;
    private Integer idMovimentacao;
    private Integer status; // 1 - Padrão, 2 - Danificado / Inutilizável, 3 - Em manutenção
    private Date manutencao;
    private Integer frequenciaDeManutencao; // Em dias

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getManutencao() {
        return manutencao;
    }

    public void setManutencao(Date manutencao) {
        this.manutencao = manutencao;
    }

    public Integer getFrequenciaDeManutencao() {
        return frequenciaDeManutencao;
    }

    public void setFrequenciaDeManutencao(Integer frequenciaDeManutencao) {
        this.frequenciaDeManutencao = frequenciaDeManutencao;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString(){
        return "ID: "+this.id+" | Nome: "+this.nome+" | Numero: "+this.numero;
    }
}
