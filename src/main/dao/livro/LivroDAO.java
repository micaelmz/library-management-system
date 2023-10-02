package main.dao.livro;

import main.model.Livro;

import java.util.List;

public interface LivroDAO {
    public Livro criar(Livro objeto);
    public List<Livro> lerTodos();
    public Livro encontrarLivro(Livro objeto);
    public Livro atualizar(Livro objeto);
    public void deletar(Livro objeto);
    public void deletarTodos();
}