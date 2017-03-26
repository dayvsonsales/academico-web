package model.instituicional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dayvson on 26/03/2017.
 */
@Entity
public class SolicitacaoTrancamento implements Serializable {

    private Integer id;
    private Discente discente;
    private List<Disciplina> disciplinas;
    private Periodo periodoSolicitacaoTrancamento;
    private String justificativa;
    private StatusTrancamento statusTrancamento;
    private Date dataSolicitacao;

    public SolicitacaoTrancamento(){
        this.disciplinas = new ArrayList<Disciplina>();
        this.dataSolicitacao = new Date();
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne
    public Discente getDiscente() {
        return discente;
    }

    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @NotNull
    @ManyToOne
    public Periodo getPeriodoSolicitacaoTrancamento() {
        return periodoSolicitacaoTrancamento;
    }

    public void setPeriodoSolicitacaoTrancamento(Periodo periodoSolicitacaoTrancamento) {
        this.periodoSolicitacaoTrancamento = periodoSolicitacaoTrancamento;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public StatusTrancamento getStatusTrancamento() {
        return statusTrancamento;
    }

    public void setStatusTrancamento(StatusTrancamento statusTrancamento) {
        this.statusTrancamento = statusTrancamento;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}
