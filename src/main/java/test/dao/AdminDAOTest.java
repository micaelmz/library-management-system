package test.dao;

import app.dao.UtilityAllUsers;
import app.dao.UtilityDatFilesFolder;
import app.model.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.dao.AdminDAOList;

import java.io.IOException;

public class AdminDAOTest {

    AdminDAOList adminDAOList;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        UtilityDatFilesFolder.enableTestMode();
        adminDAOList = new AdminDAOList();
        adminDAOList.create(new Admin("johndoe","123456","John Doe"));
        adminDAOList.create(new Admin("janedoe","123456","Jane Doe"));
    }

    @After
    public void tearDown() throws IOException {
        UtilityAllUsers.resetId();
        UtilityDatFilesFolder.disableTestMode();
    }

    @Test
    public void testFindById() {
        assertEquals("John Doe", adminDAOList.findById(0).getName());
        assertEquals("janedoe", adminDAOList.findById(1).getUsername());
    }

    @Test
    public void testUpdate() {
        Admin admin = adminDAOList.findById(0);
        admin.setName("John Doe Jr.");
        adminDAOList.update(admin);
        assertEquals("John Doe Jr.", adminDAOList.findById(0).getName());
    }

    @Test
    public void testDelete() {
        adminDAOList.delete(adminDAOList.findById(0));
        assertNull(adminDAOList.findById(0));
    }

    @Test
    public void testDeleteAll() {
        adminDAOList.deleteAll();
        assertTrue(adminDAOList.getAll().isEmpty());
    }

    @Test
    public void testDataPersistence() throws IOException, ClassNotFoundException {
        adminDAOList.saveDatFile();
        adminDAOList.deleteAll();
        adminDAOList.loadDatFile();
        assertFalse(adminDAOList.getAll().isEmpty());
    }
}
