package model.patrimonio;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
    private Status status; // 1 - Padrão, 2 - Danificado / Inutilizável, 3 - Em manutenção
    private Date manutencao;
    private String descricao;
    private Integer frequenciaDeManutencao; // Em dias

    private List<Movimentacao> movimentacoes;

    @OneToMany (mappedBy = "patrimonio", fetch = FetchType.EAGER)
    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    @NotBlank
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotBlank
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @NotNull
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @NotNull
    public Date getManutencao() {
        return manutencao;
    }

    public void setManutencao(Date manutencao) {
        this.manutencao = manutencao;
    }

    @NotNull
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

    @NotBlank
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString(){
        return this.nome + " - Numero: " + this.numero;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Patrimonio other = (Patrimonio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
