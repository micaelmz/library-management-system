package thejoseviictor.biblioteca.dao.livro;

import thejoseviictor.biblioteca.model.Livro;

import java.util.List;

public interface LivroDAO {
    public Livro criar(Livro objeto);
    public List<Livro> lerTodos();
    public Livro encontrarLivro(Livro objeto);
    public Livro atualizar(Livro objeto);
    public void deletar(Livro objeto);
    public void deletarTodos();
}
