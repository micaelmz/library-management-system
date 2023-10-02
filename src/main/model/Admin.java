package main.model;

import java.time.LocalDate;

/**
 * <b>Esta classe implementa os administradores do Sistema de Biblioteca</b>
 * Os administradores possuem poder absoluto sobre todos os métodos.
 *
 * Exemplo de Uso:
 * Admin admin = new Admin(id,"usuario", "senha", "nome");
 *
 * @author Micael Muniz
 *
 * @see main.model.Cargo
 * @see main.model.Usuario
 */

public class Admin extends Operadores{
    public Admin(Integer id, String usuario, String senha, String nome) {
        super(
            id,
            usuario,
            senha,
            nome,
            Cargo.ADMIN
        );
    }

    /**
     * Método que bane um leitor por atraso
     * @param leitor objeto do leitor
     * @param diasBanido quantidade de dias de banimento
     * @return banimento bem-sucedido, caso o leitor NÃO tenha banimentos posteriores
     * @return banimento mal-sucedido, caso o leitor TENHA banimentos posteriores
     */
    public boolean banirLeitor(Leitor leitor, Integer diasBanido) {
        if (!leitor.isBanido()) {
            leitor.setBanidoAte(LocalDate.now().plusDays(diasBanido));
            return true;
        }
        return false;
    }
}