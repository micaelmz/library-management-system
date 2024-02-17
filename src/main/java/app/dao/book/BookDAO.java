package app.dao.book;

import app.model.Book;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para livros</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Book
 */
public interface BookDAO {
    /**
     * Método que carrega os Livros do arquivo binário "Livros.dat" para a lista "listaLivros".
     */
    public void loadDatFile() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Livros da lista "listaLivros" para o arquivo binário "Livros.dat".
     */
    public void saveDatFile() throws IOException;

    /**
     * Método que cria um novo livro
     *
     * @param model model do livro
     * @return model do livro
     */
    public Book create(Book model);

    /**
     * Método que retorna todos os livros
     *
     * @return lista de livros
     */
    public List<Book> getAll();

    /**
     * Método que retorna um livro específico
     *
     * @param id model do livro
     * @return retorna um livro específico
     */
    public Book findById(Integer id);

    /**
     * Método que atualiza os atributos de um livro específico
     *
     * @param model model do livro
     * @return model do livro
     */
    public Book update(Book model);

    /**
     * Método que remove um livro específico
     *
     * @param model model do livro
     */
    public void delete(Book model);

    /**
     * Método que remove todos os livros
     */
    public void deleteAll();
}
