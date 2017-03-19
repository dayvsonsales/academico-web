package model.concurso;

import model.instituicional.Servidor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Dayvson on 19/03/2017.
 */
@Entity
public class Concurso implements Serializable {
    private Integer id;
    private String nome;
    private String edital;
    private String areaEstudo;
    private Servidor supervisor;
    private Date dataTerminoInscricao;
    private Date dataConcurso;
    private Date dataInicioInscricao;
    private String modalidade;

    private List<Servidor> banca;
    private List<Participante> participantes;

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

    @NotBlank
    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    @NotBlank
    public String getAreaEstudo() {
        return areaEstudo;
    }

    public void setAreaEstudo(String areaEstudo) {
        this.areaEstudo = areaEstudo;
    }

    @ManyToOne
    @NotNull
    public Servidor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Servidor supervisor) {
        this.supervisor = supervisor;
    }

    @NotNull
    public Date getDataTerminoInscricao() {
        return dataTerminoInscricao;
    }

    public void setDataTerminoInscricao(Date dataTerminoInscricao) {
        this.dataTerminoInscricao = dataTerminoInscricao;
    }

    @NotNull
    public Date getDataConcurso() {
        return dataConcurso;
    }

    public void setDataConcurso(Date dataConcurso) {
        this.dataConcurso = dataConcurso;
    }

    @NotNull
    public Date getDataInicioInscricao() {
        return dataInicioInscricao;
    }

    public void setDataInicioInscricao(Date dataInicioInscricao) {
        this.dataInicioInscricao = dataInicioInscricao;
    }

    @NotBlank
    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    @ManyToMany
    public List<Servidor> getBanca() {
        return banca;
    }

    public void setBanca(List<Servidor> banca) {
        this.banca = banca;
    }

    @ManyToMany
    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
