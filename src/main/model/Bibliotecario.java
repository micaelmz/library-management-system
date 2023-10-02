package main.model;

public class Bibliotecario extends Operadores{

    public Bibliotecario(Integer id, String usuario, String senha, String cargo, String nome) {
        super(
            id,
            usuario,
            senha,
            nome,
            cargo
        );
    }

    public Emprestimo criarEmprestimo(Leitor leitor, Livro livro, Integer diasEmpretados, Integer renovacoes) {
        if (leitor.isBanido()) {
            return null;
        }
        return new Emprestimo(leitor, livro, diasEmpretados, renovacoes);
    }

}
