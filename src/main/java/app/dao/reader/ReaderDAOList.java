package app.dao.reader;

import app.dao.DatFilesFolder;
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
public class ReaderDAOList implements ReaderDAO {
    private List<Reader> readers;
    private Integer lastId = 0;
    private String filePath = System.getProperty("user.dir") + "\\files\\Readers.dat";

    public ReaderDAOList() {
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
        DatFilesFolder folder = new DatFilesFolder();
        folder.ensureDestinationFolderExists();
        FileOutputStream file = new FileOutputStream(filePath);
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(readers);
    }

    /**
     * Método que cria um novo leitor
     * @param model model do leitor
     * @return model do leitor
     */
    @Override
    public Reader create(Reader model){
        // Vai verificar se o model já existe na lista.
        if (!readers.contains(model)){
            lastId++;
            model.setId(lastId);
            readers.add(model);
        }
        return model;
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
    public Reader update(Reader model) {
        if (readers.contains(model)){
            readers.set(readers.indexOf(model), model);
        }
        return model;
    }

    /**
     * Método que remove um leitor específico
     * @param model model do leitor
     */
    @Override
    public void delete(Reader model) {
        readers.remove(model);
    }

    /**
     * Método que remove todos os leitores
     */
    @Override
    public void deleteAll() {
        readers.clear();
    }
}
