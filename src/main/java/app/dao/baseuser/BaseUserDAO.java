package app.dao.baseuser;

import app.model.BaseUser;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para usuários</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see BaseUser
 */
public interface BaseUserDAO {
    /**
     * Método que carrega os Usuários do arquivo binário "Usuarios.dat" para a lista "listaUsuarios".
     */
    public void loadDatFile() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Usuários da lista "listaUsuarios" para o arquivo binário "Usuarios.dat".
     */
    public void saveDatFile() throws IOException;

    /**
     * Método que cria um novo usuário
     *
     * @param model model do usuário
     * @return model do usuário
     */
    public BaseUser create(BaseUser model);

    /**
     * Método que retorna todos os usuários
     *
     * @return lista de usuários
     */
    public List<BaseUser> getAll();

    /**
     * Método que retorna um usuário específico
     *
     * @param id model do usuário
     * @return retorna um usuário específico
     */
    public BaseUser findById(Integer id);

    /**
     * Método que atualiza os atributos de um usuário específico
     *
     * @param compare model do usuário para comparar
     * @param model model do usuário para substituir
     */
    public void update(BaseUser compare, BaseUser model);

    /**
     * Método que remove um usuário específico
     *
     * @param model model do usuário
     */
    public void delete(BaseUser model);

    /**
     * Método que remove todos os usuários
     */
    public void deleteAll();

    public BaseUser findByUsername(String username);
}
