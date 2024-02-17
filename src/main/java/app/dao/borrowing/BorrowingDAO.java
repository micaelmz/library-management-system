package app.dao.borrowing;

import app.model.Borrowing;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para empréstimos</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Borrowing
 */
public interface BorrowingDAO {
    /**
     * Método que carrega os Emprestimos do arquivo binário "Emprestimos.dat" para a lista "listaEmprestimos".
     */
    public void loadDatFile() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Emprestimos da lista "listaEmprestimos" para o arquivo binário "Emprestimos.dat".
     */
    public void saveDatFile() throws IOException;

    /**
     * Método que cria um novo empréstimo
     *
     * @param model model do empréstimo
     * @return model do empréstimo
     */
    public Borrowing create(Borrowing model);

    /**
     * Método que retorna todos os empréstimos
     *
     * @return lista de empréstimos
     */
    public List<Borrowing> getAll();

    /**
     * Método que retorna um empréstimo específico
     *
     * @param id model do empréstimo
     * @return retorna um empréstimo específico
     */
    public Borrowing findById(Integer id);

    /**
     * Método que atualiza os atributos de um empréstimo específico
     *
     * @param model model do empréstimo
     * @return model do empréstimo
     */
    public Borrowing update(Borrowing model);

    /**
     * Método que remove um empréstimo específico
     *
     * @param model model do empréstimo
     */
    public void delete(Borrowing model);

    /**
     * Método que remove todos os empréstimos
     */
    public void deleteAll();
}
