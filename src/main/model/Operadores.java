package main.model;

import main.enums.Cargo;

/**
 * <b>Esta classe implementa os operadores do Sistema de Biblioteca, como Administradores e Bibliotecários</b>
 *
 * Exemplo de Uso:
 * Operadores operador = new Operador("usuario", "senha", "nome", "cargo");
 *
 * @author Micael Muniz
 *
 * @see main.enums.Cargo
 * @see main.model.Usuario
 */
public class Operadores extends Usuario{

    public Operadores(String usuario, String senha, String nome, Cargo cargo) {
        super(
            usuario,
            senha,
            nome
        );
        this.setCargo(cargo);
    }
}
