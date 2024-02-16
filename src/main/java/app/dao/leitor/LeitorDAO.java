package app.dao.leitor;

import app.model.Leitor;
import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para leitores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see app.model.Leitor
 */
public interface LeitorDAO {
    /**
     * Método que carrega os Leitores do arquivo binário "Leitores.dat" para a lista "listaLeitores".
     */
    public void carregarArquivo() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Leitores da lista "listaLeitores" para o arquivo binário "Leitores.dat".
     */
    public void salvarArquivo() throws IOException;

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
     * @param id objeto do leitor
     * @return retorna um leitor específico
     */
    public Leitor encontrarPorID(Integer id);

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
