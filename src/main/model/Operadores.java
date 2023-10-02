package main.model;

/**
 * <b>Esta classe implementa os operadores do Sistema de Biblioteca, como Administradores e Bibliotecários</b>
 *
 * Exemplo de Uso:
 * Operadores operador = new Operador(id,"usuario", "senha", "nome", "cargo");
 *
 * @author Micael Muniz
 *
 * @see main.model.Cargo
 * @see main.model.Usuario
 */

public class Operadores extends Usuario{

    public Operadores(Integer id, String usuario, String senha, String nome, Cargo cargo) {
        super(
            id,
            usuario,
            senha,
            nome
        );
        this.setCargo(cargo);
    }
}
