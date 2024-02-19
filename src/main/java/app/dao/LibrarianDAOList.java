package app.dao;

import app.dao.CRUD;
import app.dao.DatFilesFolder;

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
    private Integer lastId = 0;
    private String filePath = System.getProperty("user.dir") + "\\files\\Librarians.dat";

    public LibrarianDAOList() {
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
        DatFilesFolder folder = new DatFilesFolder();
        folder.ensureDestinationFolderExists();
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
    public Librarian create(Librarian object) {
        // Vai verificar se o model já existe na lista.
        if (!librarians.contains(object)) {
            lastId++;
            object.setId(lastId);
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
    public void update(Librarian oldObject, Librarian newObject) {
        // Vai verificar se o model já existe na lista.
        if (librarians.contains(oldObject)) {
            librarians.set(librarians.indexOf(oldObject), newObject);
        }
    }

    /**
     * Método que remove um bibliotecário específico
     *
     * @param object model do bibliotecário
     */
    @Override
    public void delete(Librarian object) {
        librarians.remove(object);
    }

    /**
     * Método que remove todos os bibliotecários
     */
    @Override
    public void deleteAll() {
        librarians.clear();
    }
}
