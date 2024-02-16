package app.model;

import app.enums.Cargo;

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
 * @see app.enums.Cargo
 * @see app.model.Usuario
 */
public class Bibliotecario extends Operadores implements Serializable {

    public Bibliotecario(String usuario, String senha, String nome) {
        super(
            usuario,
            senha,
            nome,
            Cargo.BIBLIOTECARIO
        );
    }

    /**
     * Método que cria um novo empréstimo para um leitor
     * @param leitor objeto do leitor
     * @param livro objeto do livro
     * @param diasEmpretados dias totais do empréstimo
     * @param renovacoes quantidade de renovações
     * @return empréstimo mal-sucedido (banimentos pendentes), bem-sucedido ou reserva (não há cópias disponíveis)
     */
    public Emprestimo criarEmprestimo(Leitor leitor, Livro livro, Integer diasEmpretados, Integer renovacoes) {
        if (leitor.isBanido()) {
            return null;
        }

        Emprestimo novoEmprestimo = new Emprestimo(leitor, livro, diasEmpretados, renovacoes);

        if (livro.isDisponivel()){
            livro.adicionarEmprestimo(novoEmprestimo);
        }
        else{
            novoEmprestimo.setAsReservado();
            livro.adicionarReserva(novoEmprestimo);
        }

        leitor.adicionarAoHistoricoEmprestimos(novoEmprestimo);

        return novoEmprestimo;
    }
}
