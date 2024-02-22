package app.dao;

import app.model.Admin;
import app.model.BaseUser;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD, para evitar repetição de código</b>
 *
 * @author Micael Muniz
 */
public interface CRUD<T> {

    public void saveDatFile() throws IOException;
    public void loadDatFile() throws IOException, ClassNotFoundException;
    public T findById(Integer id);
    public T create(T object) throws IOException, ClassNotFoundException;
    public List<T> getAll();
    public void update(T newObject);
    public void delete(T object);
    public void deleteAll();
}
