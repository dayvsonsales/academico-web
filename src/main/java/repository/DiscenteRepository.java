package repository;

import model.instituicional.AlunosPorCursoDto;
import model.instituicional.Discente;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dayvson on 13/03/2017.
 */
public class DiscenteRepository extends RepositoryBase<Discente> {
    public DiscenteRepository() {
        super(Discente.class);
    }

    public Discente buscarPorMatricula(String matricula){
        TypedQuery<Discente> query = manager().createQuery("SELECT d FROM Discente d WHERE d.matricula = :matricula", Discente.class);
        query.setParameter("matricula", matricula);

        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }finally {
            manager().close();
        }
    }

    public List<Discente> buscarPorCurso(Integer cursoId){
        TypedQuery<Discente> query = manager().createQuery("SELECT d FROM Discente d WHERE d.curso.id = :curso", Discente.class);
        query.setParameter("curso", cursoId);

        try{
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }finally {
            manager().close();
        }
    }

    public List<AlunosPorCursoDto> quantidadePorCurso() {
        Query query = manager().createQuery("SELECT C.nome AS curso, count(D.id) AS quantidadeAlunos FROM Discente D INNER JOIN Curso C ON C.id = D.curso.id GROUP BY C.nome");
        Iterator iterator = query.getResultList().iterator();

        List<AlunosPorCursoDto> result = new ArrayList<AlunosPorCursoDto>();
        while (iterator.hasNext()) {
            Object[] tuple = (Object[]) iterator.next();

            AlunosPorCursoDto alunosPorCurso = new AlunosPorCursoDto((String) tuple[0], (Long) tuple[1]);
            result.add(alunosPorCurso);
        }

        return result;
    }
}
