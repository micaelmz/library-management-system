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
 * @see app.model.Admin
 */
public interface AdminDAO {
    /**
     * Método que carrega os Admins do arquivo binário "Admins.dat" para a lista "listaAdmins".
     */
    public void loadDatFile() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Admins da lista "listaAdmins" para o arquivo binário "Admins.dat".
     */
    public void saveDatFile() throws IOException;

    /**
     * Método que cria um novo administrador
     *
     * @param model model do administrador
     * @return model do administrador
     */
    public Admin create(Admin model);

    /**
     * Método que retorna todos os administradores
     *
     * @return lista de administradores
     */
    public List<Admin> getAll();

    /**
     * Método que retorna um administrador específico
     *
     * @param id model do administrador
     * @return retorna um administrador específico
     */
    public Admin findById(Integer id);

    /**
     * Método que atualiza os atributos de um administrador específico
     *
     * @param model model do administrador
     * @return model do administrador
     */
    public Admin update(Admin model);

    /**
     * Método que remove um administrador específico
     *
     * @param model model do administrador
     */
    public void delete(Admin model);

    /**
     * Método que remove todos os administradores
     */
    public void deleteAll();
}
