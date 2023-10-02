package main.dao.usuario;

import main.model.Usuario;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para usuários</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Usuario
 * @see main.dao.usuario.UsuarioDAO
 */
public class UsuarioDAOList implements UsuarioDAO{
    private List<Usuario> listaUsuarios;

    public UsuarioDAOList() {
        this.listaUsuarios = new LinkedList<Usuario>();
    }

    /**
     * Método que cria um novo usuário
     * @param objeto objeto do usuário
     * @return objeto do usuário
     */
    @Override
    public Usuario criar(Usuario objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaUsuarios.contains(objeto)){
            listaUsuarios.add(objeto);
        }
        return objeto;
    }

    /**
     * Método que retorna todos os usuários
     * @return lista de usuários
     */
    @Override
    public List<Usuario> lerTodos(){
        return listaUsuarios;
    }

    /**
     * Método que retorna um usuário específico
     * @param objeto objeto do usuário
     * @return retorna um usuário específico
     */
    @Override
    public Usuario encontrarUsuario(Usuario objeto) {
        for (Usuario percorrer : listaUsuarios){
            if (percorrer.getUsuario().equalsIgnoreCase(objeto.getUsuario())){
                return percorrer;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um usuário específico
     * @param objeto objeto do usuário
     * @return objeto do usuário
     */
    @Override
    public Usuario atualizar(Usuario objeto) {
        int indice = listaUsuarios.indexOf(objeto);
        // Vai verificar se o objeto está na lista.
        if (indice != -1){
            listaUsuarios.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    /**
     * Método que remove um usuário específico
     * @param objeto objeto do usuário
     */
    @Override
    public void deletar(Usuario objeto) {
        listaUsuarios.remove(objeto);
    }

    /**
     * Método que remove todos os usuários
     */
    @Override
    public void deletarTodos() {
        listaUsuarios.clear();
    }
}
