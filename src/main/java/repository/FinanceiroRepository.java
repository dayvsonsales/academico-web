package repository;

import model.centroacademico.MovimentacaoFinanceira;

/**
 * Created by Dayvson on 11/03/2017.
 */
public class FinanceiroRepository extends RepositoryBase<MovimentacaoFinanceira> {
    public FinanceiroRepository() {
        super(MovimentacaoFinanceira.class);
    }
}
