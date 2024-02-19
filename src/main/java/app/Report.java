package app;

import app.dao.BorrowingDAOList;
import app.dao.ReaderDAOList;
import app.enums.BorrowingStatus;
import app.model.Book;
import app.model.Borrowing;
import app.model.Reader;

import java.util.*;

/**
 * <b>Esta classe permite gerar relatorios e estatisticas</b>
 *
 * @author Micael Muniz
 */

public class Report {
    BorrowingDAOList borrowingDAOList;
    ReaderDAOList readerDAOList;
    LinkedList<Borrowing> borrowings;
    LinkedList<Borrowing> overDueBooks;
    LinkedList<Borrowing> reservedBooks;

    public Report(BorrowingDAOList borrowingDAOList, ReaderDAOList readerDAOList) {
        this.borrowingDAOList = borrowingDAOList;
        this.readerDAOList = readerDAOList;
        this.borrowings = new LinkedList<>();
        this.overDueBooks = new LinkedList<>();
        this.reservedBooks = new LinkedList<>();
    }

    /**
     * Método que separa os empréstimos em ativos, em atraso e reservados, em forma de listas
     */
    public void generateBorrowingList() {
        for (Borrowing borrowing : borrowingDAOList.getAll()) {
            if (borrowing.getStatus().equals(BorrowingStatus.ACTIVE)) {
                borrowings.add(borrowing);
            } else if (borrowing.getStatus().equals(BorrowingStatus.RESERVED)) {
                reservedBooks.add(borrowing);
            }
            if (borrowing.isOverdue()) {
                overDueBooks.add(borrowing);
            }
        }
    }

    /**
     * Método que retorna a lista de empréstimos de um leitor
     * @param id id do leitor
     * @return lista de empréstimos do leitor
     */
    public LinkedList<Borrowing> getBorrowingsByReader(Integer id) {
        Reader reader = readerDAOList.findById(id);
        if (reader != null) {
            return reader.getBorrowingHistory();
        }
        return null;
    }

    /**
     * Método que retorna a quantidade de empréstimos de um leitor
     * @param id id do leitor
     * @return quantidade de empréstimos do leitor
     */
    public Integer getBorrowingQuantityByReader(Integer id) {
        return getBorrowingsByReader(id).size();
    }

    /**
     * Método que retorna os empéstimos ativos (empréstimos que ainda não foram devolvidos)
     * @return lista de empréstimos ativos
     */
    public LinkedList<Borrowing> getBorrowings() {
        return borrowings;
    }

    /**
     * Método que retorna os empréstimos em atraso
     * @return lista de empréstimos em atraso
     */
    public LinkedList<Borrowing> getOverDueBooks() {
        return overDueBooks;
    }

    /**
     * Método que retorna os empréstimos reservados (empréstimos na fila de espera)
     * @return lista de empréstimos reservados
     */
    public LinkedList<Borrowing> getReservedBooks() {
        return reservedBooks;
    }

    /**
     * Método que retorna os livros mais populares (livros com mais empréstimos)
     * o metodo separa os emprestimos em um HashMap com Livro : Quantidade de emprestimos
     * e depois cria uma lista ordenada por quantidade de emprestimos de forma decrescente
     * @return lista de livros mais populares
     */
    public List<Book> getHotBooks() {
        HashMap<Book, Integer> booksToCount = new HashMap<>();

        // Salva em um HashMap a quantidade de empréstimos de cada livro unico
        for (Borrowing borrowing : borrowingDAOList.getAll()) {
            booksToCount.put(borrowing.getBook(), booksToCount.getOrDefault(borrowing.getBook(), 0) + 1);
        }

        // Organiza uma lista com livros únicos ordenados por quantidade de empréstimos
        List<Book> hotBooks = new ArrayList<>(booksToCount.keySet());
        hotBooks.sort(Comparator.comparingInt(booksToCount::get).reversed());

        return hotBooks;
    }
}
