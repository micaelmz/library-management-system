package app;

import app.model.Usuario;

/**
 * <b>Esta classe permite gerenciar o usuário logado ao sistema atualmente</b>
 * Possuindo um atributo do tipo Usuario
 *
 * @author Micael Muniz
 */

public class GlobalData {

    private static Usuario usuarioAtual;

    /**
     * Método que retorna o usuário logado ao sistema atualmente
     * @return usuário logado ao sistema atualmente
     */
    public static Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    /**
     * Método que alterna o usuário logado ao sistema atualmente
     * @param usuario usuario a ser conectado
     */
    public static void setUsuarioAtual(Usuario usuario) {
        usuarioAtual = usuario;
    }
}
