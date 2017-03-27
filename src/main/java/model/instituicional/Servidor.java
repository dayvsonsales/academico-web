package model.instituicional;

import model.tcc.Banca;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dayvson on 13/03/2017.
 */
@Entity
public class Servidor implements Serializable {

    private Integer id;
    private String nome;
    private String siape;
    private String cargo;
    private String cpf;
    private SituacaoServidor situacao;

    private List<Banca> bancas;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank(message = "Não pode estar vazio")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotBlank(message = "Não pode estar vazio")
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    @NotBlank(message = "Não pode estar vazio")
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @NotBlank(message = "Não pode estar vazio")
    @CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @ManyToMany
    public List<Banca> getBancas() {
        return bancas;
    }

    public void setBancas(List<Banca> bancas) {
        this.bancas = bancas;
    }

    public SituacaoServidor getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoServidor situacao) {
        this.situacao = situacao;
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
        Servidor other = (Servidor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    @Override
    public String toString(){
        return this.id + " - " + this.nome;
    }
}
