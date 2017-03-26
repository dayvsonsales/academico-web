package model.tcc;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dayvson on 13/03/2017.
 */
@Entity
public class Convidado {

    private Integer id;
    private String nome;
    private String cpf;
    private String descricao;

    private List<Banca> bancas;

    @NotBlank
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotBlank
    @CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @NotBlank
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany
    public List<Banca> getBancas() {
        return bancas;
    }

    public void setBancas(List<Banca> bancas) {
        this.bancas = bancas;
    }
}
