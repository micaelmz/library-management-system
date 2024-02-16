package app.dao.admin;

import app.model.Admin;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para administradores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see app.model.Admin
 */
public interface AdminDAO {
    /**
     * Método que carrega os Admins do arquivo binário "Admins.dat" para a lista "listaAdmins".
     */
    public void carregarArquivo() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Admins da lista "listaAdmins" para o arquivo binário "Admins.dat".
     */
    public void salvarArquivo() throws IOException;

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
     * @param id objeto do administrador
     * @return retorna um administrador específico
     */
    public Admin encontrarPorID(Integer id);

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
