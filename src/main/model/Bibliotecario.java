package main.model;

import main.enums.Cargo;

public class Bibliotecario extends Operadores{

    public Bibliotecario(String usuario, String senha, String nome) {
        super(
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
