package app.model;

import app.enums.BorrowingStatus;
import app.enums.Role;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <b>Esta classe implementa os recibos de empréstimo de cada leitor</b>
 * Contendo os seguintes atributos:
 * Leitor associado (Leitor)
 * Livro associado (Livro)
 * Data de início do empréstimo (LocalDate)
 * Data prevista de entrega (LocalDate)
 * Dias emprestados (Integer)
 * Quantidade de renovações (Integer)
 * Status do Empréstimo (StatusEmprestimo): ATIVO, RESERVADO ou FINALIZADO
 * ID do empréstimo
 * <p>
 * Apenas os Administradores e Bibliotecários podem criar empréstimos.
 * <p>
 * Exemplo de Uso:
 * Emprestimo emprestimo = new Emprestimo(Leitor, Livro, diasEmprestados, renovacoes);
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Role
 * @see BaseUser
 * @see Reader
 * @see Book
 */
public class Borrowing implements Serializable {
    private final Reader reader;
    private final Book book;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private Integer loanDays;
    private Integer renewals;
    private BorrowingStatus status;
    private Integer id;

    public Borrowing(Reader reader, Book book, Integer loanDays, Integer renewals) {
        this.reader = reader;
        this.book = book;
        this.renewals = renewals;
        this.loanDays = loanDays;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(loanDays);
        this.status = BorrowingStatus.ACTIVE;
    }

    /**
     * Método que retorna o leitor associado ao empréstimo
     *
     * @return leitor associado ao empréstimo
     */
    public Reader getReader() {
        return reader;
    }

    /**
     * Método que retorna o livro associado ao empréstimo
     *
     * @return livro associado ao empréstimo
     */
    public Book getBook() {
        return book;
    }

    /**
     * Método que retorna a data de início do empréstimo
     *
     * @return data de início do empréstimo
     */
    public LocalDate getLoanDate() {
        return loanDate;
    }

    /**
     * Método que retorna a data de entrega do livro
     *
     * @return data de entrega do livro
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Método que retorna a quantidade de dias do empréstimo
     *
     * @return quantidade de dias do empréstimo
     */
    public Integer getLoanDays() {
        return loanDays;
    }

    /**
     * Método que retorna a quantidade de renovações do empréstimo
     *
     * @return quantidade de renovações do empréstimo
     */
    public Integer getRenewals() {
        return renewals;
    }

    /**
     * Método que retorna o ID do empréstimo
     *
     * @return ID do empréstimo
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que modifica o ID do empréstimo
     *
     * @param id id do empréstimo
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que modifica a quantidade de renovações do empréstimo
     *
     * @param renewals quantidade de renovações do empréstimo
     */
    public void setRenewals(Integer renewals) {
        this.renewals = renewals;
    }

    /**
     * Método que modifica a data de entrega do livro
     *
     * @param dueDate data de entrega do livro
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Método que modifica a quantidade de dias do empréstimo
     *
     * @param loanDays quantidade de dias do empréstimo
     */
    public void setLoanDays(Integer loanDays) {
        this.loanDays = loanDays;
    }

    /**
     * Método que modifica a data de início do empréstimo
     *
     * @param loanDate data de início do empréstimo
     */
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * Método que modifica o status do empréstimo para FINALIZADO
     */
    public void setAsFinished() {
        this.status = BorrowingStatus.FINISHED;
    }

    /**
     * Método que modifica o status do empréstimo para ATIVO
     */
    public void setAsActive() {
        this.status = BorrowingStatus.ACTIVE;
    }

    /**
     * Método que modifica o status do empréstimo para RESERVADO
     */
    public void setAsReserved() {
        this.status = BorrowingStatus.RESERVED;
        this.dueDate = LocalDate.MAX;
    }

    /**
     * Método que retorna o status do empréstimo
     *
     * @return status do empréstimo
     */
    public BorrowingStatus getStatus() {
        return this.status;
    }

    /**
     * Método que retorna se o empréstimo está atrasado
     *
     * @return empréstimo está atrasado (true ou false)
     */
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    /**
     * Método que retorna se o empréstimo pode ser renovado
     *
     * @return empréstimo pode ser renovado (true ou false)
     */
    public boolean isEligibleForRenewal() {
        return this.renewals > 0 && !isOverdue() && this.status == BorrowingStatus.ACTIVE && this.book.getReservations().isEmpty();
    }

    /**
     * Método que retorna a quantidade de dias de multa por atraso
     *
     * @return quantidade de dias de multa por atraso
     */
    private int calculatePenalty() {
        // Calcula multa: 2 dias de banimento para cada dia de atraso.
        int daysOverdue = (int) (LocalDate.now().toEpochDay() - dueDate.toEpochDay());
        if (daysOverdue > 0) {
            return daysOverdue * 2;
        } else {
            return 0;
        }
    }

    /**
     * Método que renova um empréstimo
     *
     * @return bem-sucedido ou mal-sucedido (se não houverem renovações disponíveis)
     */
    public boolean renew() {
        //todo: verificar se é o usuário atual é um bibliotecário.
        if (isEligibleForRenewal()) {
            this.renewals--;
            this.dueDate = this.dueDate.plusDays(this.loanDays);
            return true;
        }
        return false;
    }

    /**
     * Método que encerra um empréstimo, adiciona dias de banimento por atraso
     * e cria um empréstimo para o primeiro usuário na lista de reserva
     *
     * @return devolução bem-sucedida
     */
    public boolean returnBook() {
        if (isOverdue()) {
            // Banir leitor por 2 dias para cada dia de atraso.
            reader.setBannedUntil(LocalDate.now().plusDays(calculatePenalty()));
        }

        this.setAsFinished();

        if (!book.getReservations().isEmpty()) {
            Borrowing proximoBorrowing = book.getReservations().getFirst();
            proximoBorrowing.setAsActive();
            proximoBorrowing.setDueDate(LocalDate.now().plusDays(proximoBorrowing.getLoanDays()));
            book.addBorrowing(proximoBorrowing);
            book.removeReservation(proximoBorrowing);
        }

        book.removeBorrowing(this);

        return true;
    }
}
