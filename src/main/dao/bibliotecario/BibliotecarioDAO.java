package main.dao.bibliotecario;

import main.model.Bibliotecario;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para bibliotecários</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Bibliotecario
 */
public interface BibliotecarioDAO {
    /**
     * Método que carrega os Bibliotecarios do arquivo binário "Bibliotecarios.dat" para a lista "listaBibliotecarios".
     */
    public void carregarArquivo() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Bibliotecarios da lista "listaBibliotecarios" para o arquivo binário "Bibliotecarios.dat".
     */
    public void salvarArquivo() throws IOException;

    /**
     * Método que cria um novo bibliotecário
     * @param objeto objeto do bibliotecário
     * @return objeto do bibliotecário
     */
    public Bibliotecario criar(Bibliotecario objeto);

    /**
     * Método que retorna todos os bibliotecários
     * @return lista de bibliotecários
     */
    public List<Bibliotecario> lerTodos();

    /**
     * Método que retorna um bibliotecário específico
     * @param id objeto do bibliotecário
     * @return retorna um bibliotecário específico
     */
    public Bibliotecario encontrarPorID(Integer id);

    /**
     * Método que atualiza os atributos de um bibliotecário específico
     * @param objeto objeto do bibliotecário
     * @return objeto do bibliotecário
     */
    public Bibliotecario atualizar(Bibliotecario objeto);

    /**
     * Método que remove um bibliotecário específico
     * @param objeto objeto do bibliotecário
     */
    public void deletar(Bibliotecario objeto);

    /**
     * Método que remove todos os bibliotecários
     */
    public void deletarTodos();
}
