package app.dao;

import app.model.Borrowing;
import app.model.Librarian;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para empréstimos</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Librarian
 * @see LibrarianDAO
 */
public class BorrowingDAOList implements CRUD<Borrowing> {
    private List<Borrowing> borrowings;
    private Integer lastId = 0;
    private String filePath;

    public BorrowingDAOList() {
        this.filePath = UtilityDatFilesFolder.getFolderPath() + "\\Borrowings.dat"; // todo: verificar se isso causa acoplamento
        this.borrowings = new LinkedList<Borrowing>();
    }

    /**
     * Método que carrega os Emprestimos do arquivo binário "Emprestimos.dat" para a lista "listaEmprestimos".
     */
    @Override
    public void loadDatFile() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filePath);
        ObjectInputStream object = new ObjectInputStream(file);
        borrowings = (LinkedList<Borrowing>) object.readObject();
    }

    /**
     * Método que salva os Emprestimos da lista "listaEmprestimos" para o arquivo binário "Emprestimos.dat".
     */
    @Override
    public void saveDatFile() throws IOException {
        UtilityDatFilesFolder.createIfNotExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(borrowings);
    }

    /**
     * Método que cria um novo empréstimo
     *
     * @param object model do empréstimo
     * @return model do empréstimo
     */
    @Override
    public Borrowing create(Borrowing object) {
        // Vai verificar se o model já existe na lista.
        if (!borrowings.contains(object)) {
            lastId++;
            object.setId(lastId);
            borrowings.add(object);
        }
        return object;
    }

    /**
     * Método que retorna todos os empréstimos
     *
     * @return lista de empréstimos
     */
    @Override
    public List<Borrowing> getAll() {
        return borrowings;
    }

    /**
     * Método que retorna um empréstimo específico
     *
     * @param id model do empréstimo
     * @return retorna um empréstimo específico
     */
    @Override
    public Borrowing findById(Integer id) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getId().equals(id)) {
                return borrowing;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um empréstimo específico
     *
     * @param model model do empréstimo
     * @return model do empréstimo
     */
    @Override
    public void update(Borrowing oldObject, Borrowing newObject) {
        // Vai verificar se o model já existe na lista.
        if (borrowings.contains(oldObject)) {
            borrowings.set(borrowings.indexOf(oldObject), newObject);
        }
    }

    /**
     * Método que remove um empréstimo específico
     *
     * @param object model do empréstimo
     */
    @Override
    public void delete(Borrowing object) {
        borrowings.remove(object);
    }

    /**
     * Método que remove todos os empréstimos
     */
    @Override
    public void deleteAll() {
        borrowings.clear();
    }

    public String getFilePath() {
        return filePath;
    }
}
