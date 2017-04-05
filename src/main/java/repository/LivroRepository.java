package repository;

import model.biblioteca.Livro;

/**
 * Created by anderson on 04/04/17.
 */
public class LivroRepository extends RepositoryBase<Livro> {
    public LivroRepository() { super(Livro.class); }
}
