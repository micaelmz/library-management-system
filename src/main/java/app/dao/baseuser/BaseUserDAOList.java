package app.dao.baseuser;

import app.dao.DatFilesFolder;
import app.model.BaseUser;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para usuários</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat".
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see BaseUser
 * @see BaseUserDAO
 */
public class BaseUserDAOList implements BaseUserDAO {
    private List<BaseUser> baseusers;
    private Integer lastId = 0;
    private String filePath = System.getProperty("user.dir") + "\\files\\BaseUsers.dat";

    public BaseUserDAOList() {
        this.baseusers = new LinkedList<BaseUser>();
    }

    /**
     * Método que carrega os Usuários do arquivo binário "Usuarios.dat" para a lista "listaUsuarios".
     */
    @Override
    public void loadDatFile() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filePath);
        ObjectInputStream object = new ObjectInputStream(file);
        baseusers = (LinkedList<BaseUser>) object.readObject();
    }

    /**
     * Método que salva os Usuários da lista "listaUsuarios" para o arquivo binário "Usuarios.dat".
     */
    @Override
    public void saveDatFile() throws IOException {
        DatFilesFolder folder = new DatFilesFolder();
        folder.ensureDestinationFolderExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(baseusers);
    }

    /**
     * Método que cria um novo usuário
     *
     * @param model model do usuário
     * @return model do usuário
     */
    @Override
    public BaseUser create(BaseUser model) {
        // Vai verificar se o model já existe na lista.
        if (!baseusers.contains(model)) {
            lastId++;
            model.setId(lastId);
            baseusers.add(model);
        }
        return model;
    }

    /**
     * Método que retorna todos os usuários
     *
     * @return lista de usuários
     */
    @Override
    public List<BaseUser> getAll() {
        return baseusers;
    }

    /**
     * Método que retorna um usuário específico
     *
     * @param id model do usuário
     * @return retorna um usuário específico
     */
    @Override
    public BaseUser findById(Integer id) {
        for (BaseUser baseUser : baseusers) {
            if (baseUser.getId().equals(id)) {
                return baseUser;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um usuário específico
     *
     * @param compare model do usuário para comparar
     * @param model model do usuário para substituir
     */
    @Override
    public void update(BaseUser compare, BaseUser model) {
        // Vai verificar se o model já existe na lista.
        if (baseusers.contains(compare)) {
            baseusers.set(baseusers.indexOf(compare), model);
        }
    }

    /**
     * Método que remove um usuário específico
     *
     * @param model model do usuário
     */
    @Override
    public void delete(BaseUser model) {
        baseusers.remove(model);
    }

    /**
     * Método que remove todos os usuários
     */
    @Override
    public void deleteAll() {
        baseusers.clear();
    }

    @Override
    public BaseUser findByUsername(String username) {
        for (BaseUser user : baseusers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
