package app.model;

import app.enums.Cargo;

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
 * @see app.enums.Cargo
 * @see app.model.Usuario
 * @see app.model.Emprestimo
 */
public class Leitor extends Usuario implements Serializable{
    private String endereco;
    private String telefone;
    private LocalDate banidoAte;
    private LinkedList<Emprestimo> historicoEmprestimo = new LinkedList<>();

    public Leitor(String usuario, String senha, String nome, String endereco, String telefone) {
        super(
            usuario,
            senha,
            nome
        );
        this.endereco = endereco;
        this.telefone = telefone;
        this.setCargo(Cargo.LEITOR);
    }

    /**
     * Método que retorna o endereço do leitor
     * @return endereço do leitor
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Método que retorna o telefone do leitor
     * @return telefone do leitor
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método que retorna quando o banimento do leitor irá terminar
     * @return data de fim do banimento do leitor
     */
    public LocalDate getBanidoAte() {
        return banidoAte;
    }

    /**
     * Método que retorna o histórico de empréstimos do leitor
     * @return histórico de empréstimos do leitor
     */
    public LinkedList<Emprestimo> getHistoricoEmprestimo() {
        return historicoEmprestimo;
    }

    /**
     * Método que retorna se o leitor está banido
     * @return leitor está banido (true ou false)
     */
    public boolean isBanido() {
        return banidoAte != null && banidoAte.isAfter(LocalDate.now());
    }

    /**
     * Método que modifica o endereço do leitor
     * @param endereco endereço do leitor
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Método que modifica o telefone do leitor
     * @param telefone telefone do leitor
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Método que modifica a data de fim do banimento do leitor
     * @param banidoAte data do banimento do leitor
     */
    public void setBanidoAte(LocalDate banidoAte) {
        this.banidoAte = banidoAte;
    }

    /**
     * Método que adiciona um empréstimo ao leitor
     * @param emprestimo empréstimo do leitor
     */
    public void adicionarAoHistoricoEmprestimos(Emprestimo emprestimo) {
        historicoEmprestimo.add(emprestimo);
    }
}
