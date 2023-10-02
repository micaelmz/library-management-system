package main.dao.livro;

import main.model.Livro;

import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para livros</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Livro
 */
public interface LivroDAO {
    /**
     * Método que cria um novo livro
     * @param objeto objeto do livro
     * @return objeto do livro
     */
    public Livro criar(Livro objeto);

    /**
     * Método que retorna todos os livros
     * @return lista de livros
     */
    public List<Livro> lerTodos();

    /**
     * Método que retorna um livro específico
     * @param id objeto do livro
     * @return retorna um livro específico
     */
    public Livro encontrarPorID(Integer id);

    /**
     * Método que atualiza os atributos de um livro específico
     * @param objeto objeto do livro
     * @return objeto do livro
     */
    public Livro atualizar(Livro objeto);

    /**
     * Método que remove um livro específico
     * @param objeto objeto do livro
     */
    public void deletar(Livro objeto);

    /**
     * Método que remove todos os livros
     */
    public void deletarTodos();
}
