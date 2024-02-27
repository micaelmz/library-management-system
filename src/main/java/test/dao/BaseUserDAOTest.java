package test.dao;

import app.dao.BaseUserDAOList;
import app.dao.UtilityAllUsers;
import app.dao.UtilityDatFilesFolder;
import app.model.BaseUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class BaseUserDAOTest {

    BaseUserDAOList baseUserDAOList;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        UtilityDatFilesFolder.enableTestMode();
        baseUserDAOList = new BaseUserDAOList();
        baseUserDAOList.create(new BaseUser("johndoe", "123456", "John Doe"));
        baseUserDAOList.create(new BaseUser("janedoe", "123456", "Jane Doe"));
    }

    @After
    public void tearDown() throws IOException {
        UtilityAllUsers.resetId();
        UtilityDatFilesFolder.disableTestMode();
    }

    @Test
    public void testFindById() {
        assertEquals("johndoe", baseUserDAOList.findById(0).getUsername());
        assertEquals("janedoe", baseUserDAOList.findById(1).getUsername());
    }

    @Test
    public void testUpdate() {
        BaseUser oldUserInfo = baseUserDAOList.findById(0);
        BaseUser newUserInfo = oldUserInfo;
        newUserInfo.setName("John Doe 2");
        baseUserDAOList.update(newUserInfo);
        assertEquals("John Doe 2", baseUserDAOList.findById(0).getName());
    }

    @Test
    public void testeDelete() {
        baseUserDAOList.delete(baseUserDAOList.findById(0));
        assertNull(baseUserDAOList.findById(0));
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
        assertEquals("janedoe", baseUserDAOList.findById(1).getUsername());
    }
}
