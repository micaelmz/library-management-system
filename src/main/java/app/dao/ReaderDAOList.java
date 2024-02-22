package app.dao;

import app.model.Reader;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para leitores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see Reader
 * @see ReaderDAO
 */
public class ReaderDAOList implements CRUD<Reader> {
    private List<Reader> readers;
    private String filePath;

    public ReaderDAOList() {
        this.filePath = UtilityDatFilesFolder.getFolderPath() + "\\Readers.dat"; // todo: verificar se isso causa acoplamento
        this.readers = new LinkedList<Reader>();
    }

    /**
     * Método que carrega os Leitores do arquivo binário "Leitores.dat" para a lista "listaLeitores".
     */
    @Override
    public void loadDatFile() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filePath);
        ObjectInputStream object = new ObjectInputStream(file);
        readers = (LinkedList<Reader>) object.readObject();
    }

    /**
     * Método que salva os Leitores da lista "listaLeitores" para o arquivo binário "Leitores.dat".
     */
    @Override
    public void saveDatFile() throws IOException{
        UtilityDatFilesFolder.createIfNotExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(readers);
    }

    /**
     * Método que cria um novo leitor
     * @param object model do leitor
     * @return model do leitor
     */
    @Override
    public Reader create(Reader object) throws IOException, ClassNotFoundException {
        // Vai verificar se o model já existe na lista.
        if (!readers.contains(object)){
            object.setId(UtilityAllUsers.getNewId());
            readers.add(object);
        }
        return object;
    }

    /**
     * Método que retorna todos os leitores
     * @return lista de leitores
     */
    @Override
    public List<Reader> getAll() {
        return readers;
    }

    /**
     * Método que retorna um leitor específico
     * @param id model do leitor
     * @return retorna um leitor específico
     */
    @Override
    public Reader findById(Integer id) {
        for (Reader reader : readers) {
            if (reader.getId().equals(id)){
                return reader;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um leitor específico
     * @param model model do leitor
     * @return model do leitor
     */
    @Override
    public void update(Reader newObject) {
        Integer id = newObject.getId()
        if (findById(id) != null) {
            readers.remove(findById(id));
            readers.add(newObject);
        }
    }

    /**
     * Método que remove um leitor específico
     * @param object model do leitor
     */
    @Override
    public void delete(Reader object) {
        Integer id = object.getId()
        if (findById(id) != null) {
            readers.remove(findById(id));
        }
    }

    /**
     * Método que remove todos os leitores
     */
    @Override
    public void deleteAll() {
        readers.clear();
    }

    public String getFilePath() {
        return filePath;
    }
}
