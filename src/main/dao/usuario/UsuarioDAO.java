package main.dao.usuario;

import main.model.Usuario;

import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para usuários</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Usuario
 */
public interface UsuarioDAO {
    /**
     * Método que cria um novo usuário
     * @param objeto objeto do usuário
     * @return objeto do usuário
     */
    public Usuario criar(Usuario objeto);

    /**
     * Método que retorna todos os usuários
     * @return lista de usuários
     */
    public List<Usuario> lerTodos();

    /**
     * Método que retorna um usuário específico
     * @param objeto objeto do usuário
     * @return retorna um usuário específico
     */
    public Usuario encontrarUsuario(Usuario objeto);

    /**
     * Método que atualiza os atributos de um usuário específico
     * @param objeto objeto do usuário
     * @return objeto do usuário
     */
    public Usuario atualizar(Usuario objeto);

    /**
     * Método que remove um usuário específico
     * @param objeto objeto do usuário
     */
    public void deletar(Usuario objeto);

    /**
     * Método que remove todos os usuários
     */
    public void deletarTodos();
}
