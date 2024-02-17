package app.model;

import app.enums.Role;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 * <b>Esta classe implementa os leitores do Sistema de Biblioteca e seus atributos</b>
 * Cada Leitor possue as seguintes informações:
 * Endereço (String)
 * Telefone (String)
 * Dias de Banimento por Atraso (LocalDate)
 * Histórico de Empréstimos (LinkedList)
 *
 * Apenas os Administradores podem adicionar dias de banimento ao Leitor.
 * Os dias de banimento por atraso são calculados da seguinte maneira:
 * Dias de Banimento = Dias de Atraso * 2
 *
 * Exemplo de Uso:
 * Leitor leitor = new Leitor("usuario", "senha", "nome", "endereço", "telefone");
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see Role
 * @see BaseUser
 * @see Borrowing
 */
public class Reader extends BaseUser implements Serializable{
    private String address;
    private String phoneNumber;
    private LocalDate bannedUntil;
    private LinkedList<Borrowing> borrowingHistory = new LinkedList<>();

    public Reader(String username, String password, String name, String address, String phoneNumber) {
        super(
            username,
            password,
            name
        );
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.setRole(Role.READER);
    }

    /**
     * Método que retorna o endereço do leitor
     * @return endereço do leitor
     */
    public String getAddress() {
        return address;
    }

    /**
     * Método que retorna o telefone do leitor
     * @return telefone do leitor
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Método que retorna quando o banimento do leitor irá terminar
     * @return data de fim do banimento do leitor
     */
    public LocalDate getBannedUntil() {
        return bannedUntil;
    }

    /**
     * Método que retorna o histórico de empréstimos do leitor
     * @return histórico de empréstimos do leitor
     */
    public LinkedList<Borrowing> getBorrowingHistory() {
        return borrowingHistory;
    }

    /**
     * Método que retorna se o leitor está banido
     * @return leitor está banido (true ou false)
     */
    public boolean isBanned() {
        return bannedUntil != null && bannedUntil.isAfter(LocalDate.now());
    }

    /**
     * Método que modifica o endereço do leitor
     * @param address endereço do leitor
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Método que modifica o telefone do leitor
     * @param phoneNumber telefone do leitor
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Método que modifica a data de fim do banimento do leitor
     * @param bannedUntil data do banimento do leitor
     */
    public void setBannedUntil(LocalDate bannedUntil) {
        this.bannedUntil = bannedUntil;
    }

    /**
     * Método que adiciona um empréstimo ao leitor
     * @param borrowing empréstimo do leitor
     */
    public void addToBorrowingHistory(Borrowing borrowing) {
        borrowingHistory.add(borrowing);
    }
}
