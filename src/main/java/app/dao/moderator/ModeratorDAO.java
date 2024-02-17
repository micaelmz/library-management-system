package app.dao.moderator;

import app.model.Moderator;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para operadores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Moderator
 */
public interface ModeratorDAO {
    /**
     * Método que carrega os Operadores do arquivo binário "Operadores.dat" para a lista "listaOperadores".
     */
    public void loadDatFile() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Operadores da lista "listaOperadores" para o arquivo binário "Operadores.dat".
     */
    public void saveDatFile() throws IOException;

    /**
     * Método que cria um novo operador
     *
     * @param model model do operador
     * @return model do operador
     */
    public Moderator create(Moderator model);

    /**
     * Método que retorna todos os operadores
     *
     * @return lista de operadores
     */
    public List<Moderator> getAll();

    /**
     * Método que retorna um operador específico
     *
     * @param id model do operador
     * @return retorna um operador específico
     */
    public Moderator findById(Integer id);

    /**
     * Método que atualiza os atributos de um operador específico
     *
     * @param model model do operador
     * @return model do operador
     */
    public Moderator update(Moderator model);

    /**
     * Método que remove um operador específico
     *
     * @param model model do operador
     */
    public void delete(Moderator model);

    /**
     * Método que remove todos os operadores
     */
    public void deleteAll();
}
