package app.model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * <b>Esta classe implementa os livros da Biblioteca e suas cópias</b>
 * Contendo as seguintes informações:
 * ID do livro
 * Título do livro
 * Autor do livro
 * ISBN do livro (International Standard Book Number | Padrão Internacional de Numeração de Livro)
 * Ano de publicação do livro
 * Categoria do livro
 * Quantidade de cópias do livro
 * Limite de renovações do livro
 * Lista de empréstimos
 * Lista de reservas
 * <p>
 * Exemplo de Uso:
 * Livro livro = new Livro(id, "titulo", "autor", "isbn", anoPublicacao, "categoria", quantidade, limiteRenovacoes);
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 */
public class Book implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private String category;
    private Integer quantity;
    private Integer renewalLimit;
    private LinkedList<Borrowing> borrowedBooks;
    private LinkedList<Borrowing> reservations;

    public Book(String title, String author, String isbn,
                Integer publicationYear, String category, int quantity, Integer renovationLimit) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.category = category;
        this.quantity = quantity;
        this.renewalLimit = renovationLimit;
        this.borrowedBooks = new LinkedList<Borrowing>();
        this.reservations = new LinkedList<Borrowing>();
    }

    /**
     * Método que retorna o ID do livro
     *
     * @return ID do livro
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que retorna o título do livro
     *
     * @return título do livro
     */
    public String getTitle() {
        return title;
    }

    /**
     * Método que retorna o autor do livro
     *
     * @return autor do livro
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Método que retorna o ISBN do livro
     *
     * @return ISBN do livro
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Método que retorna o ano de publicação do livro
     *
     * @return ano de publicação do livro
     */
    public Integer getPublicationYear() {
        return publicationYear;
    }

    /**
     * Método que retorna a categoria do livro
     *
     * @return categoria do livro
     */
    public String getCategory() {
        return category;
    }

    /**
     * Método que retorna a quantidade de cópias do livro
     *
     * @return quantidade de cópias do livro
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Método que retorna a lista de empréstimos do livro
     *
     * @return lista de empréstimos do livro
     */
    public LinkedList<Borrowing> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Método que retorna a lista de reservas do livro
     *
     * @return lista de reservas do livro
     */
    public LinkedList<Borrowing> getReservations() {
        return reservations;
    }

    /**
     * Método que retorna o limite de renovações do livro
     *
     * @return limite de renovações do livro
     */
    public Integer getRenewalLimit() {
        return renewalLimit;
    }

    /**
     * Método que modifica o ID do livro
     *
     * @param id id do livro
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que modifica o título do livro
     *
     * @param title titulo do livro
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Método que modifica o autor do livro
     *
     * @param author autor do livro
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Método que modifica o ISBN do livro
     *
     * @param isbn ISBN do livro
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Método que modifica o ano de publicação do livro
     *
     * @param publicationYear ano de publicação do livro
     */
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Método que modifica a categoria do livro
     *
     * @param category categoria do livro
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Método que modifica a quantidade de cópias do livro
     *
     * @param quantity quantidade de cópias do livro
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Método que modifica o limite de renovações do livro
     *
     * @param renewalLimit limite de renovações do livro
     */
    public void setRenewalLimit(Integer renewalLimit) {
        this.renewalLimit = renewalLimit;
    }

    /**
     * Método que adiciona um empréstimo à lista de empréstimos do livro
     *
     * @param borrowing objeto do empréstimo
     */
    public void addBorrowing(Borrowing borrowing) {
        this.borrowedBooks.add(borrowing);
    }

    /**
     * Método que adiciona uma reserva à lista de reservas do livro
     *
     * @param borrowing objeto do empréstimo
     */
    public void addReservation(Borrowing borrowing) {
        this.reservations.add(borrowing);
    }

    /**
     * Método que remove um empréstimo da lista de empréstimos do livro
     *
     * @param borrowing objeto do empréstimo
     */
    public void removeBorrowing(Borrowing borrowing) {
        this.borrowedBooks.remove(borrowing);
    }

    /**
     * Método que remove uma reserva da lista de reservas do livro
     *
     * @param borrowing objeto do empréstimo
     */
    public void removeReservation(Borrowing borrowing) {
        this.reservations.remove(borrowing);
    }

    /**
     * Método que retorna se o livro possui cópias disponíveis
     *
     * @return livro possui cópias disponíveis (true ou false)
     */
    public boolean isAvailable() {
        return this.quantity > this.borrowedBooks.size();
    }
}
