package main.model;

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
