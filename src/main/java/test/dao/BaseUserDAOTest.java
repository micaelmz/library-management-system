package test.dao;

import app.dao.baseuser.BaseUserDAOList;
import app.model.BaseUser;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class BaseUserDAOTest {

    BaseUserDAOList baseUserDAOList = new BaseUserDAOList();

    @Before
    public void setUp() {
        baseUserDAOList.create(new BaseUser("johndoe", "123456", "John Doe"));
        baseUserDAOList.create(new BaseUser("janedoe", "123456", "Jane Doe"));
    }
    @Test
    public void testFindById() {
        assertEquals("johndoe", baseUserDAOList.findById(1).getUsername());
        assertEquals("janedoe", baseUserDAOList.findById(2).getUsername());
    }

    @Test
    public void testUpdate() {
        BaseUser baseUser = baseUserDAOList.findById(1);
        baseUser.setName("John Doe 2");
        baseUserDAOList.update(baseUser);
        assertEquals("John Doe 2", baseUserDAOList.findById(1).getName());
    }

    @Test
    public void testeDelete() {
        baseUserDAOList.delete(baseUserDAOList.findById(1));
        assertNull(baseUserDAOList.findById(1));
    }

    @Test
    public void testeDeleteAll() {
        baseUserDAOList.deleteAll();
        assertTrue(baseUserDAOList.getAll().isEmpty());
    }

    @Test
    public void testDataPersistence() throws IOException, ClassNotFoundException {
        baseUserDAOList.saveDatFile();
        baseUserDAOList.deleteAll();
        baseUserDAOList.loadDatFile();
        assertEquals("johndoe", baseUserDAOList.findById(1).getUsername());
    }
}
