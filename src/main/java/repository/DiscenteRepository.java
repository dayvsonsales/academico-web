package repository;

import model.instituicional.Curso;
import model.instituicional.Discente;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Dayvson on 13/03/2017.
 */
public class DiscenteRepository extends RepositoryBase {
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
}
