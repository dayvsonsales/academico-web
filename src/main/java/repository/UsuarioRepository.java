package repository;

import model.Usuario;
import util.HashUtils;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by anderson on 13/03/17.
 */
public class UsuarioRepository extends RepositoryBase<Usuario> {
    public UsuarioRepository() {
        super(Usuario.class);
    }

    @Override
    public Usuario save(Usuario entity) {
        String senhaHash = HashUtils.stringParaHash(entity.getSenha());
        entity.setSenha(senhaHash);

        return super.save(entity);
    }

    public Usuario validarEmailSenha(String email, String senha) {
        senha = HashUtils.stringParaHash(senha);

        TypedQuery<Usuario> query = manager().createQuery("SELECT U FROM Usuario U WHERE U.email = :email AND U.senha = :senha", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        try {
            Usuario usuario = query.getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            return null;
        } finally {
            manager().close();
        }

    }

}
