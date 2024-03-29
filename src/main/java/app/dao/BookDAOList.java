package app.dao;

import app.model.Book;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para livros</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Book
 * @see BookDAO
 */
public class BookDAOList implements CRUD<Book> {
    private List<Book> books;
    private Integer lastId = 0;
    private String filePath;

    public BookDAOList() {
        this.filePath = UtilityDatFilesFolder.getFolderPath() + "\\Books.dat"; // todo: verificar se isso causa acoplamento
        this.books = new LinkedList<Book>();
    }

    /**
     * Método que carrega os Livros do arquivo binário "Livros.dat" para a lista "listaLivros".
     */
    @Override
    public void loadDatFile() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filePath);
        ObjectInputStream object = new ObjectInputStream(file);
        books = (LinkedList<Book>) object.readObject();
    }

    /**
     * Método que salva os Livros da lista "listaLivros" para o arquivo binário "Livros.dat".
     */
    @Override
    public void saveDatFile() throws IOException {
        UtilityDatFilesFolder.createIfNotExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(books);
    }

    /**
     * Método que cria um novo livro
     *
     * @param object model do livro
     * @return model do livro
     */
    @Override
    public Book create(Book object) throws IOException, ClassNotFoundException {
        // Vai verificar se o model já existe na lista.
        if (!books.contains(object)) {
            object.setId(getNewId());
            books.add(object);
        }
        return object;
    }

    /**
     * Método que retorna todos os livros
     *
     * @return lista de livros
     */
    @Override
    public List<Book> getAll() {
        return books;
    }

    /**
     * Método que retorna um livro específico
     *
     * @param id model do livro
     * @return retorna um livro específico
     */
    @Override
    public Book findById(Integer id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um livro específico
     *
     * @param model model do livro
     * @return model do livro
     */

    @Override
    public void update(Book newObject) {
        Integer id = newObject.getId();
        if (findById(id) != null) {
            books.remove(findById(id));
            books.add(newObject);
        }
    }

    /**
     * Método que remove um livro específico
     *
     * @param object model do livro
     */
    @Override
    public void delete(Book object) {
        Integer id = object.getId();
        if (findById(id) != null) {
            books.remove(findById(id));
        }
    }

    /**
     * Método que remove todos os livros
     */
    @Override
    public void deleteAll() {
        books.clear();
    }

    public String getFilePath() {
        return filePath;
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
        String filePath = UtilityDatFilesFolder.getFolderPath() + "\\id_books.dat";
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
        String filePath = UtilityDatFilesFolder.getFolderPath() + "\\id_books.dat";
        try (FileOutputStream file = new FileOutputStream(filePath);
             ObjectOutputStream object = new ObjectOutputStream(file)) {
            object.writeObject(id);
        }
    }
}
