package main.dao.usuario;

import main.model.Usuario;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para usuários</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Usuario
 */
public interface UsuarioDAO {
    /**
     * Método que carrega os Usuários do arquivo binário "Usuarios.dat" para a lista "listaUsuarios".
     */
    public void carregarArquivo() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Usuários da lista "listaUsuarios" para o arquivo binário "Usuarios.dat".
     */
    public void salvarArquivo() throws IOException;

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
     * @param id objeto do usuário
     * @return retorna um usuário específico
     */
    public Usuario encontrarPorID(Integer id);

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
