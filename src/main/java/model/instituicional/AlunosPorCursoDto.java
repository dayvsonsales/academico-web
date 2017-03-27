package model.instituicional;

import com.google.gson.annotations.SerializedName;

import java.util.Random;

/**
 * Created by anderson on 27/03/17.
 */
public class AlunosPorCursoDto {

    @SerializedName("label")
    private String curso;

    @SerializedName("value")
    private Long quantidadeAlunos;

    @SerializedName("color")
    private String cor;

    public AlunosPorCursoDto(String curso, Long quantidadeAlunos) {
        this.curso = curso;
        this.quantidadeAlunos = quantidadeAlunos;
        this.cor = gerarCor();
    }

    private String gerarCor() {
        Random random = new Random();
        int nextInt = random.nextInt(256 * 256 * 256);

        return String.format("#%06x", nextInt);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Long getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Long quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

}
