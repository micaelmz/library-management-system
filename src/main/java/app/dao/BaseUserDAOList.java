package app.dao;

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
 */
public class BaseUserDAOList implements CRUD<BaseUser>{
    private List<BaseUser> baseusers;
    private String filePath;

    public BaseUserDAOList() {
        this.filePath = UtilityDatFilesFolder.getFolderPath() + "\\BaseUsers.dat"; // todo: verificar se isso causa acoplamento
        this.baseusers = new LinkedList<BaseUser>();
    }

    /**
     * Método que carrega os Usuários do arquivo binário "Usuarios.dat" para a lista "listaUsuarios".
     */
    @Override
    public void loadDatFile() throws IOException, ClassNotFoundException {
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream object = new ObjectInputStream(file);
            baseusers = (LinkedList<BaseUser>) object.readObject();
        }
        catch (Exception FileNotFoundException){
            saveDatFile();
        }
    }

    /**
     * Método que salva os Usuários da lista "listaUsuarios" para o arquivo binário "Usuarios.dat".
     */
    @Override
    public void saveDatFile() throws IOException {
        UtilityDatFilesFolder.createIfNotExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(baseusers);
    }

    /**
     * Método que cria um novo usuário
     *
     * @param object model do usuário
     * @return model do usuário
     */
    @Override
    public BaseUser create(BaseUser object) throws IOException, ClassNotFoundException {
        // Vai verificar se o model já existe na lista.
        if (!baseusers.contains(object)) {
            object.setId(UtilityAllUsers.getNewId());
            baseusers.add(object);
        }
        return object;
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
    public void update(BaseUser newObject) {
        Integer id = newObject.getId()
        if (findById(id) != null) {
            users.remove(findById(id));
            users.add(newObject);
        }
    }

    /**
     * Método que remove um usuário específico
     *
     * @param object model do usuário
     */
    @Override
    public void delete(BaseUser object) {
        Integer id = object.getId()
        if (findById(id) != null) {
            users.remove(findById(id));
        }
    }

    /**
     * Método que remove todos os usuários
     */
    @Override
    public void deleteAll() {
        baseusers.clear();
    }

    public BaseUser findByUsername(String username) {
        for (BaseUser user : baseusers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public String getFilePath() {
        return filePath;
    }
}
