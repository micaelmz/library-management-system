package app.dao.borrowing;

import app.dao.DatFilesFolder;
import app.dao.librarian.LibrarianDAO;
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
public class BorrowingDAOList implements BorrowingDAO {
    private List<Borrowing> borrowings;
    private Integer lastId = 0;
    private String filePath = System.getProperty("user.dir") + "\\files\\Borrowings.dat";

    public BorrowingDAOList() {
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
        DatFilesFolder folder = new DatFilesFolder();
        folder.ensureDestinationFolderExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(borrowings);
    }

    /**
     * Método que cria um novo empréstimo
     *
     * @param model model do empréstimo
     * @return model do empréstimo
     */
    @Override
    public Borrowing create(Borrowing model) {
        // Vai verificar se o model já existe na lista.
        if (!borrowings.contains(model)) {
            lastId++;
            model.setId(lastId);
            borrowings.add(model);
        }
        return model;
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
    public Borrowing update(Borrowing model) {
        if (borrowings.contains(model)) {
            borrowings.set(borrowings.indexOf(model), model);
        }
        return model;
    }

    /**
     * Método que remove um empréstimo específico
     *
     * @param model model do empréstimo
     */
    @Override
    public void delete(Borrowing model) {
        borrowings.remove(model);
    }

    /**
     * Método que remove todos os empréstimos
     */
    @Override
    public void deleteAll() {
        borrowings.clear();
    }
}
