package controller;

import com.google.gson.Gson;
import model.instituicional.AlunosPorCursoDto;
import repository.DiscenteRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by anderson on 27/03/17.
 */

@ManagedBean
@ViewScoped
public class DashboardController {

    private String alunosPorCurso;

    public DashboardController() {
        this.alunosPorCurso = buscarAlunosPorCurso();
    }

    public String getAlunosPorCurso() {
        return alunosPorCurso;
    }

    public void setAlunosPorCurso(String alunosPorCurso) {
        this.alunosPorCurso = alunosPorCurso;
    }

    private String buscarAlunosPorCurso() {
        Integer totalAlunos = new DiscenteRepository().all().size();
        List<AlunosPorCursoDto> result = new DiscenteRepository().quantidadePorCurso();

        for (AlunosPorCursoDto a : result) {
            double quantidade = a.getQuantidadeAlunos();
            double porcentagem = (quantidade / totalAlunos) * 100;

            a.setQuantidadeAlunos((long) porcentagem);
        }

        return new Gson().toJson(result);
    }
}
