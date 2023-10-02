package main.dao.operadores;

import main.model.Operadores;

import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para operadores</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Operadores
 */
public interface OperadoresDAO {
    /**
     * Método que cria um novo operador
     * @param objeto objeto do operador
     * @return objeto do operador
     */
    public Operadores criar(Operadores objeto);

    /**
     * Método que retorna todos os operadores
     * @return lista de operadores
     */
    public List<Operadores> lerTodos();

    /**
     * Método que retorna um operador específico
     * @param objeto objeto do operador
     * @return retorna um operador específico
     */
    public Operadores encontrarOperador(Operadores objeto);

    /**
     * Método que atualiza os atributos de um operador específico
     * @param objeto objeto do operador
     * @return objeto do operador
     */
    public Operadores atualizar(Operadores objeto);

    /**
     * Método que remove um operador específico
     * @param objeto objeto do operador
     */
    public void deletar(Operadores objeto);

    /**
     * Método que remove todos os operadores
     */
    public void deletarTodos();
}
