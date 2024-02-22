package app.dao;

import app.model.Librarian;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para bibliotecários</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Librarian
 * @see LibrarianDAO
 */
public class LibrarianDAOList implements CRUD<Librarian> {
    private List<Librarian> librarians;
    private String filePath;

    public LibrarianDAOList() {
        this.filePath = UtilityDatFilesFolder.getFolderPath() + "\\Librarians.dat"; // todo: verificar se isso causa acoplamento
        this.librarians = new LinkedList<Librarian>();
    }

    /**
     * Método que carrega os Bibliotecarios do arquivo binário "Bibliotecarios.dat" para a lista "listaBibliotecarios".
     */
    @Override
    public void loadDatFile() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filePath);
        ObjectInputStream object = new ObjectInputStream(file);
        librarians = (LinkedList<Librarian>) object.readObject();
    }

    /**
     * Método que salva os Bibliotecarios da lista "listaBibliotecarios" para o arquivo binário "Bibliotecarios.dat".
     */
    @Override
    public void saveDatFile() throws IOException {
        UtilityDatFilesFolder.createIfNotExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(librarians);
    }

    /**
     * Método que cria um novo bibliotecário
     *
     * @param object model do bibliotecário
     * @return model do bibliotecário
     */
    @Override
    public Librarian create(Librarian object) throws IOException, ClassNotFoundException {
        // Vai verificar se o model já existe na lista.
        if (!librarians.contains(object)) {
            object.setId(UtilityAllUsers.getNewId());
            librarians.add(object);
        }
        return object;
    }

    /**
     * Método que retorna todos os bibliotecários
     *
     * @return lista de bibliotecários
     */
    @Override
    public List<Librarian> getAll() {
        return librarians;
    }

    /**
     * Método que retorna um bibliotecário específico
     *
     * @param id model do bibliotecário
     * @return retorna um bibliotecário específico
     */
    @Override
    public Librarian findById(Integer id) {
        for (Librarian librarian : librarians) {
            if (librarian.getId().equals(id)) {
                return librarian;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um bibliotecário específico
     *
     * @param model model do bibliotecário
     * @return model do bibliotecário
     */
    @Override
    public void update(Librarian newObject) {
        Integer id = newObject.getId()
        if (findById(id) != null) {
            librarians.remove(findById(id));
            librarians.add(newObject);
        }
    }

    /**
     * Método que remove um bibliotecário específico
     *
     * @param object model do bibliotecário
     */
    @Override
    public void delete(Librarian object) {
        Integer id = object.getId()
        if (findById(id) != null) {
            librarians.remove(findById(id));
        }
    }

    /**
     * Método que remove todos os bibliotecários
     */
    @Override
    public void deleteAll() {
        librarians.clear();
    }

    public String getFilePath() {
        return filePath;
    }
}
