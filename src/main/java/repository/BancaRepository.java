package repository;

import model.tcc.Banca;

import javax.persistence.TypedQuery;

/**
 * Created by anderson on 26/03/17.
 */
public class BancaRepository extends RepositoryBase<Banca> {
    public BancaRepository() {
        super(Banca.class);
    }
}
