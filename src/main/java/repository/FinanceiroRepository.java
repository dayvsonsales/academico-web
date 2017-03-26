package repository;

import model.centroacademico.MovimentacaoFinanceira;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Dayvson on 11/03/2017.
 */
public class FinanceiroRepository extends RepositoryBase<MovimentacaoFinanceira> {
    public FinanceiroRepository() {
        super(MovimentacaoFinanceira.class);
    }

    public List<MovimentacaoFinanceira> buscarPorMes(Integer mes){
        TypedQuery<MovimentacaoFinanceira> query = manager().createQuery("SELECT m FROM MovimentacaoFinanceira m WHERE MONTH(m.data) = :mes", MovimentacaoFinanceira.class);
        query.setParameter("mes", mes);

        try{
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }finally {
            manager().close();
        }
    }

}
