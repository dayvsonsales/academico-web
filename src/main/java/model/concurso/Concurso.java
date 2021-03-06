package model.concurso;

import model.instituicional.Servidor;
import org.hibernate.validator.constraints.NotBlank;

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
public class Concurso implements Serializable {

    private Integer id;
    private String nome;
    private String edital;
    private String areaEstudo;
    private Servidor supervisor = new Servidor();
    private Date dataTerminoInscricao;
    private Date dataConcurso;
    private Date dataInicioInscricao;
    private String modalidade;

    private List<Servidor> banca = new ArrayList<Servidor>();
    private List<Participante> participantes = new ArrayList<Participante>();

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

    @NotNull
    @ManyToOne
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

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Servidor> getBanca() {
        return banca;
    }

    public void setBanca(List<Servidor> banca) {
        this.banca = banca;
    }

    @ManyToMany(mappedBy = "concursos", cascade = CascadeType.ALL)
    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return this.edital +" - " +this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Concurso other = (Concurso) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
