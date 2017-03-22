package util;

import model.Permissoes;
import model.Usuario;
import repository.UsuarioRepository;

/**
 * Created by anderson on 20/03/17.
 */
public class CriarAdmin {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setNome("Admin");
        usuario.setEmail("admin@admin.com");
        usuario.setSenha("admin");
        usuario.setPermissao(Permissoes.ADMIN);

        UsuarioRepository repo = new UsuarioRepository();
        repo.save(usuario);
    }

}
