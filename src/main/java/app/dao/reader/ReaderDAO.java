package app.dao.reader;

import app.model.Reader;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para leitores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Reader
 */
public interface ReaderDAO {
    /**
     * Método que carrega os Leitores do arquivo binário "Leitores.dat" para a lista "listaLeitores".
     */
    public void loadDatFile() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Leitores da lista "listaLeitores" para o arquivo binário "Leitores.dat".
     */
    public void saveDatFile() throws IOException;

    /**
     * Método que cria um novo leitor
     *
     * @param model model do leitor
     * @return model do leitor
     */
    public Reader create(Reader model);

    /**
     * Método que retorna todos os leitores
     *
     * @return lista de leitores
     */
    public List<Reader> getAll();

    /**
     * Método que retorna um leitor específico
     *
     * @param id model do leitor
     * @return retorna um leitor específico
     */
    public Reader findById(Integer id);

    /**
     * Método que atualiza os atributos de um leitor específico
     *
     * @param model model do leitor
     * @return model do leitor
     */
    public Reader update(Reader model);

    /**
     * Método que remove um leitor específico
     *
     * @param model model do leitor
     */
    public void delete(Reader model);

    /**
     * Método que remove todos os leitores
     */
    public void deleteAll();
}
