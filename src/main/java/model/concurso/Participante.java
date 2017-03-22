package model.concurso;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dayvson on 19/03/2017.
 */
@Entity
public class Participante implements Serializable {

    private Integer id;
    private String nome;
    private String cpf;
    private Integer rg;
    private String orgaoEmissorRG;
    private Date dataNascimento;
    private String nomeMae;
    private String naturalidade;
    private boolean taxaPaga;
    private boolean isentoTaxa;
    private String endereco;
    private String email;
    private String telefone;
    private boolean aptidao;
    private String acessibilidade;

    private List<Concurso> concursos = new ArrayList<Concurso>();

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @CPF
    @NotBlank
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissorRG() {
        return orgaoEmissorRG;
    }

    public void setOrgaoEmissorRG(String orgaoEmissorRG) {
        this.orgaoEmissorRG = orgaoEmissorRG;
    }

    @NotNull
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @NotBlank
    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    @NotBlank
    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public boolean isTaxaPaga() {
        return taxaPaga;
    }

    public void setTaxaPaga(boolean taxaPaga) {
        this.taxaPaga = taxaPaga;
    }

    public boolean isIsentoTaxa() {
        return isentoTaxa;
    }

    public void setIsentoTaxa(boolean isentoTaxa) {
        this.isentoTaxa = isentoTaxa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @NotBlank
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAptidao() {
        return aptidao;
    }

    public void setAptidao(boolean aptidao) {
        this.aptidao = aptidao;
    }

    public String getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(String acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    @ManyToMany
    public List<Concurso> getConcursos() {
        return concursos;
    }

    public void setConcursos(List<Concurso> concursos) {
        this.concursos = concursos;
    }
}
