package app.dao.moderator;

import app.dao.DatFilesFolder;
import app.model.Moderator;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para operadores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Moderator
 * @see ModeratorDAO
 */
public class ModeratorDAOList implements ModeratorDAO {
    private List<Moderator> moderators;
    private Integer lastId = 0;
    private String filePath = System.getProperty("user.dir") + "\\files\\Moderators.dat";

    public ModeratorDAOList() {
        this.moderators = new LinkedList<Moderator>();
    }

    /**
     * Método que carrega os Operadores do arquivo binário "Operadores.dat" para a lista "listaOperadores".
     */
    @Override
    public void loadDatFile() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filePath);
        ObjectInputStream object = new ObjectInputStream(file);
        moderators = (LinkedList<Moderator>) object.readObject();
    }

    /**
     * Método que salva os Operadores da lista "listaOperadores" para o arquivo binário "Operadores.dat".
     */
    @Override
    public void saveDatFile() throws IOException {
        DatFilesFolder folder = new DatFilesFolder();
        folder.ensureDestinationFolderExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(moderators);
    }

    /**
     * Método que cria um novo operador
     *
     * @param model model do operador
     * @return model do operador
     */
    @Override
    public Moderator create(Moderator model) {
        // Vai verificar se o model já existe na lista.
        if (!moderators.contains(model)) {
            lastId++;
            model.setId(lastId);
            moderators.add(model);
        }
        return model;
    }

    /**
     * Método que retorna todos os operadores
     *
     * @return lista de operadores
     */
    @Override
    public List<Moderator> getAll() {
        return moderators;
    }

    /**
     * Método que retorna um operador específico
     *
     * @param id model do operador
     * @return retorna um operador específico
     */
    @Override
    public Moderator findById(Integer id) {
        for (Moderator moderator : moderators) {
            if (moderator.getId().equals(id)) {
                return moderator;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um operador específico
     *
     * @param model model do operador
     * @return model do operador
     */
    @Override
    public Moderator update(Moderator model) {
        if (moderators.contains(model)) {
            moderators.set(moderators.indexOf(model), model);
        }
        return model;
    }

    /**
     * Método que remove um operador específico
     *
     * @param model model do operador
     */
    @Override
    public void delete(Moderator model) {
        moderators.remove(model);
    }

    /**
     * Método que remove todos os operadores
     */
    @Override
    public void deleteAll() {
        moderators.clear();
    }
}
