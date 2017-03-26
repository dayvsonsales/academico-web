package repository;

import model.instituicional.Discente;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
}
