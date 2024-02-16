package app.dao.operadores;

import app.model.Operadores;
import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para operadores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see app.model.Operadores
 */
public interface OperadoresDAO {
    /**
     * Método que carrega os Operadores do arquivo binário "Operadores.dat" para a lista "listaOperadores".
     */
    public void carregarArquivo() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Operadores da lista "listaOperadores" para o arquivo binário "Operadores.dat".
     */
    public void salvarArquivo() throws IOException;

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
     * @param id objeto do operador
     * @return retorna um operador específico
     */
    public Operadores encontrarPorID(Integer id);

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
