package app.dao;

import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD, para evitar repetição de código</b>
 *
 * @author Micael Muniz
 */
public interface CRUD<T> {
    public void create(T objeto);
    public List<T> getAll();
    public T findById(long id);
    public void update(T objeto);
    public void delete(T objeto);
    public void deleteAll();
}
