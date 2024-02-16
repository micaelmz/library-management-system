package app.model;

import app.enums.Cargo;

import java.io.Serializable;

/**
 * <b>Esta classe implementa os operadores do Sistema de Biblioteca, como Administradores e Bibliotecários</b>
 *
 * Exemplo de Uso:
 * Operadores operador = new Operador("usuario", "senha", "nome", "cargo");
 *
 * @author Micael Muniz
 *
 * @see app.enums.Cargo
 * @see app.model.Usuario
 */
public class Operadores extends Usuario implements Serializable {

    public Operadores(String usuario, String senha, String nome, Cargo cargo) {
        super(
            usuario,
            senha,
            nome
        );
        this.setCargo(cargo);
    }
}
