package app.model;

import app.enums.Role;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <b>Esta classe implementa os administradores do Sistema de Biblioteca</b>
 * Os administradores possuem poder absoluto sobre todos os métodos.
 * <p>
 * Exemplo de Uso:
 * Admin admin = new Admin("usuario", "senha", "nome");
 *
 * @author Micael Muniz
 * @see enums.Role
 * @see model.BaseUsers
 */

public class Admin extends Moderator implements Serializable {
    public Admin(String username, String password, String name) {
        super(
                username,
                password,
                name,
                Role.ADMIN
        );
    }

    /**
     * Método que bane um leitor por atraso
     *
     * @param reader objeto do leitor
     * @param days   quantidade de dias de banimento
     * @return banimento bem-sucedido (caso o leitor NÃO tenha banimentos posteriores) ou banimento mal-sucedido
     */
    public boolean banReader(Reader reader, Integer days) {
        if (!reader.isBanned()) {
            reader.setBannedUntil(LocalDate.now().plusDays(days));
            return true;
        }
        return false;
    }
}
