package app.dao;

import app.enums.BorrowingStatus;
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
    public Borrowing create(Borrowing object) throws IOException, ClassNotFoundException {
        // Vai verificar se o model já existe na lista.
        if (!borrowings.contains(object)) {
            object.setId(getNewId());
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
    public void update(Borrowing newObject) {
        Integer id = newObject.getId();
        if (findById(id) != null) {
            borrowings.remove(findById(id));
            borrowings.add(newObject);
        }
    }

    /**
     * Método que remove um empréstimo específico
     *
     * @param object model do empréstimo
     */
    @Override
    public void delete(Borrowing object) {
        Integer id = object.getId();
        if (findById(id) != null) {
            borrowings.remove(findById(id));
        }
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

    public List<Borrowing> getOnlyBorrowed(){
        List<Borrowing> onlyBorrowed = new LinkedList<Borrowing>();
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getStatus().equals(BorrowingStatus.ACTIVE)) {
                onlyBorrowed.add(borrowing);
            }
        }
        return onlyBorrowed;
    }

    public List<Borrowing> getOnlyReserved(){
        List<Borrowing> onlyReserved = new LinkedList<Borrowing>();
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getStatus().equals(BorrowingStatus.RESERVED)) {
                onlyReserved.add(borrowing);
            }
        }
        return onlyReserved;
    }

    public Integer getNewId() throws IOException, ClassNotFoundException {
        Integer id = readIdFromFile();
        writeIdToFile(id + 1);
        return id;
    }

    public void resetId() throws IOException {
        writeIdToFile(0);
    }

    private Integer readIdFromFile() throws IOException, ClassNotFoundException {
        String filePath = UtilityDatFilesFolder.getFolderPath() + "\\id_borrowing.dat";
        File idFile = new File(filePath);

        if (!idFile.exists()) {
            if (!idFile.getParentFile().exists()) {
                idFile.getParentFile().mkdirs();
            }
            idFile.createNewFile();
            return 0;
        } else {
            try (FileInputStream file = new FileInputStream(filePath);
                 ObjectInputStream object = new ObjectInputStream(file)) {
                return (Integer) object.readObject();
            }
        }
    }

    private void writeIdToFile(Integer id) throws IOException {
        String filePath = UtilityDatFilesFolder.getFolderPath() + "\\id_borrowing.dat";
        try (FileOutputStream file = new FileOutputStream(filePath);
             ObjectOutputStream object = new ObjectOutputStream(file)) {
            object.writeObject(id);
        }
    }
}
