package main.dao.admin;

import main.model.Admin;

import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para administradores</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Admin
 */
public interface AdminDAO {
    /**
     * Método que cria um novo administrador
     * @param objeto objeto do administrador
     * @return objeto do administrador
     */
    public Admin criar(Admin objeto);

    /**
     * Método que retorna todos os administradores
     * @return lista de administradores
     */
    public List<Admin> lerTodos();

    /**
     * Método que retorna um administrador específico
     * @param objeto objeto do administrador
     * @return retorna um administrador específico
     */
    public Admin encontrarAdmin(Admin objeto);

    /**
     * Método que atualiza os atributos de um administrador específico
     * @param objeto objeto do administrador
     * @return objeto do administrador
     */
    public Admin atualizar(Admin objeto);

    /**
     * Método que remove um administrador específico
     * @param objeto objeto do administrador
     */
    public void deletar(Admin objeto);

    /**
     * Método que remove todos os administradores
     */
    public void deletarTodos();
}
