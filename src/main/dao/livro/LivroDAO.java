package main.dao.livro;

import main.model.Livro;
import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para livros</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Livro
 */
public interface LivroDAO {
    /**
     * Método que carrega os Livros do arquivo binário "Livros.dat" para a lista "listaLivros".
     */
    public void carregarArquivo() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Livros da lista "listaLivros" para o arquivo binário "Livros.dat".
     */
    public void salvarArquivo() throws IOException;

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
