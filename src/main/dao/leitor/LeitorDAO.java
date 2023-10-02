package main.dao.leitor;

import main.model.Leitor;

import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para leitores</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Leitor
 */
public interface LeitorDAO {
    /**
     * Método que cria um novo leitor
     * @param objeto objeto do leitor
     * @return objeto do leitor
     */
    public Leitor criar(Leitor objeto);

    /**
     * Método que retorna todos os leitores
     * @return lista de leitores
     */
    public List<Leitor> lerTodos();

    /**
     * Método que retorna um leitor específico
     * @param objeto objeto do leitor
     * @return retorna um leitor específico
     */
    public Leitor encontrarLeitor(Leitor objeto);

    /**
     * Método que atualiza os atributos de um leitor específico
     * @param objeto objeto do leitor
     * @return objeto do leitor
     */
    public Leitor atualizar(Leitor objeto);

    /**
     * Método que remove um leitor específico
     * @param objeto objeto do leitor
     */
    public void deletar(Leitor objeto);

    /**
     * Método que remove todos os leitores
     */
    public void deletarTodos();
}
