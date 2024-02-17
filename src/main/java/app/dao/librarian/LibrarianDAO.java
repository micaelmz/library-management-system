package app.dao.librarian;

import app.model.Librarian;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para bibliotecários</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Librarian
 */
public interface LibrarianDAO {
    /**
     * Método que carrega os Bibliotecarios do arquivo binário "Bibliotecarios.dat" para a lista "listaBibliotecarios".
     */
    public void loadDatFile() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Bibliotecarios da lista "listaBibliotecarios" para o arquivo binário "Bibliotecarios.dat".
     */
    public void saveDatFile() throws IOException;

    /**
     * Método que cria um novo bibliotecário
     *
     * @param model model do bibliotecário
     * @return model do bibliotecário
     */
    public Librarian create(Librarian model);

    /**
     * Método que retorna todos os bibliotecários
     *
     * @return lista de bibliotecários
     */
    public List<Librarian> getAll();

    /**
     * Método que retorna um bibliotecário específico
     *
     * @param id model do bibliotecário
     * @return retorna um bibliotecário específico
     */
    public Librarian findById(Integer id);

    /**
     * Método que atualiza os atributos de um bibliotecário específico
     *
     * @param model model do bibliotecário
     * @return model do bibliotecário
     */
    public Librarian update(Librarian model);

    /**
     * Método que remove um bibliotecário específico
     *
     * @param model model do bibliotecário
     */
    public void delete(Librarian model);

    /**
     * Método que remove todos os bibliotecários
     */
    public void deleteAll();
}
