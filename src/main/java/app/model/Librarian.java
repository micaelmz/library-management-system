package app.model;

import app.enums.Role;

import java.io.Serializable;

/**
 * <b>Esta classe implementa os bibliotecários do Sistema de Biblioteca</b>
 * Os bibliotecários possuem as seguintes permissões:
 * Registrar novos livros
 * Pesquisar livros
 * Fazer empréstimos ou devoluções
 *
 * Exemplo de Uso:
 * Bibliotecario bibliotecario = new Bibliotecario("usuario", "senha", "nome");
 *
 * @author Micael Muniz
 *
 * @see Role
 * @see BaseUser
 */
public class Librarian extends Moderator implements Serializable {

    public Librarian(String username, String password, String name) {
        super(
            username,
            password,
            name,
            Role.LIBRARIAN
        );
    }

    /**
     * Método que cria um novo empréstimo para um leitor
     * @param reader objeto do leitor
     * @param book objeto do livro
     * @param loanDays dias totais do empréstimo
     * @param renewals quantidade de renovações
     * @return empréstimo mal-sucedido (banimentos pendentes), bem-sucedido ou reserva (não há cópias disponíveis)
     */
    public Borrowing borrowBook(Reader reader, Book book, Integer loanDays, Integer renewals) {
        if (reader.isBanned()) {
            return null;
        }

        Borrowing newBorrowing = new Borrowing(reader, book, loanDays, renewals);

        if (book.isAvailable()){
            book.addBorrowing(newBorrowing);
        }
        else{
            newBorrowing.setAsReserved();
            book.addReservation(newBorrowing);
        }

        reader.addToBorrowingHistory(newBorrowing);

        return newBorrowing;
    }
}
