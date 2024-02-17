package app.model;

import app.enums.Role;

import java.io.Serializable;

/**
 * <b>Esta classe implementa os operadores do Sistema de Biblioteca, como Administradores e Bibliotecários</b>
 *
 * Exemplo de Uso:
 * Operadores operador = new Operador("usuario", "senha", "nome", "cargo");
 *
 * @author Micael Muniz
 *
 * @see Role
 * @see BaseUser
 */
public class Moderator extends BaseUser implements Serializable {

    public Moderator(String username, String password, String name, Role role) {
        super(
            username,
            password,
            name
        );
        this.setRole(role);
    }
}
