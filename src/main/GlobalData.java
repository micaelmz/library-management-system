package main;

import main.model.Usuario;

public class GlobalData {

    private static Usuario usuarioAtual;

    public static Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public static void setUsuarioAtual(Usuario usuario) {
        usuarioAtual = usuario;
    }
}
