package test.dao;

import app.model.Admin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.dao.admin.AdminDAOList;

import java.io.IOException;

public class AdminDAOTest {

    AdminDAOList adminDAOList = new AdminDAOList();

    @Before
    public void setUp() {
        adminDAOList.create(new Admin("johndoe","123456","John Doe"));
        adminDAOList.create(new Admin("janedoe","123456","Jane Doe"));
    }

    @Test
    public void testFindById() {
        assertEquals("janedoe", adminDAOList.findById(2).getUsername());
        assertEquals("John Doe", adminDAOList.findById(1).getName());
    }

    @Test
    public void testUpdate() {
        Admin admin = adminDAOList.findById(1);
        admin.setName("John Doe Jr.");
        adminDAOList.update(admin);
        assertEquals("John Doe Jr.", adminDAOList.findById(1).getName());
    }

    @Test
    public void testDelete() {
        adminDAOList.delete(adminDAOList.findById(1));
        assertNull(adminDAOList.findById(1));
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
        assertEquals("johndoe", adminDAOList.findById(1).getUsername());
    }
}
