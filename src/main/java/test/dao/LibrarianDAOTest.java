package test.dao;

import app.dao.LibrarianDAOList;
import app.dao.UtilityAllUsers;
import app.dao.UtilityDatFilesFolder;
import app.model.Librarian;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class LibrarianDAOTest {

    LibrarianDAOList bibliotecarioDAOList;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        UtilityDatFilesFolder.enableTestMode();
        bibliotecarioDAOList = new LibrarianDAOList();
        bibliotecarioDAOList.create(new Librarian("johndoe","123456","John Doe"));
        bibliotecarioDAOList.create(new Librarian("janedoe","123456","Jane Doe"));
    }

    @After
    public void tearDown() throws IOException {
        UtilityAllUsers.resetId();
        UtilityDatFilesFolder.deleteIfExists();
    }

    @Test
    public void testFindById() {
        assertEquals("John Doe", bibliotecarioDAOList.findById(0).getName());
        assertEquals("janedoe", bibliotecarioDAOList.findById(1).getUsername());
    }

    @Test
    public void testUpdate() {
        Librarian librarian = bibliotecarioDAOList.findById(0);
        librarian.setName("John Doe Jr.");
        bibliotecarioDAOList.update(librarian);
        assertEquals("John Doe Jr.", bibliotecarioDAOList.findById(0).getName());
    }

    @Test
    public void testDelete() {
        bibliotecarioDAOList.delete(bibliotecarioDAOList.findById(0));
        assertNull(bibliotecarioDAOList.findById(0));
    }

    @Test
    public void testDeleteAll() {
        bibliotecarioDAOList.deleteAll();
        assertTrue(bibliotecarioDAOList.getAll().isEmpty());
    }

    @Test
    public void testDataPersistence() throws IOException, ClassNotFoundException {
        bibliotecarioDAOList.saveDatFile();
        bibliotecarioDAOList.deleteAll();
        bibliotecarioDAOList.loadDatFile();
        assertFalse(bibliotecarioDAOList.getAll().isEmpty());
    }
}
