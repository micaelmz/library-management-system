package main.model;

/**
 * <b>Esta classe implementa os bibliotecários do Sistema de Biblioteca</b>
 * Os bibliotecários possuem as seguintes permissões:
 * Registrar novos livros
 * Pesquisar livros
 * Fazer empréstimos ou devoluções
 *
 * Exemplo de Uso:
 * Bibliotecario bibliotecario = new Bibliotecario(id,"usuario", "senha", "nome");
 *
 * @author Micael Muniz
 *
 * @see main.model.Cargo
 * @see main.model.Usuario
 */
public class Bibliotecario extends Operadores{

    public Bibliotecario(Integer id, String usuario, String senha, String nome) {
        super(
            id,
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
        if (livro.isDisponivel()) {
            livro.decrementar();
            Emprestimo novoEmprestimo = new Emprestimo(leitor, livro, diasEmpretados, renovacoes);
            leitor.adicionarEmprestimo(novoEmprestimo);
            return novoEmprestimo;
        }
        else {
            // todo: retorna uma reserva
            return null;
        }
    }

}
