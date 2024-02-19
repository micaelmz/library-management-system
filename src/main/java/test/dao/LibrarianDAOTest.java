package test.dao;

import app.dao.LibrarianDAOList;
import app.model.Librarian;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class LibrarianDAOTest {

    LibrarianDAOList bibliotecarioDAOList = new LibrarianDAOList();

    @Before
    public void setUp() {
        bibliotecarioDAOList.create(new Librarian("johndoe","123456","John Doe"));
        bibliotecarioDAOList.create(new Librarian("janedoe","123456","Jane Doe"));
    }

    @Test
    public void testFindById() {
        assertEquals("janedoe", bibliotecarioDAOList.findById(2).getUsername());
        assertEquals("John Doe", bibliotecarioDAOList.findById(1).getName());
    }

    @Test
    public void testUpdate() {
        Librarian librarian = bibliotecarioDAOList.findById(1);
        librarian.setName("John Doe Jr.");
        bibliotecarioDAOList.update(librarian, librarian);
        assertEquals("John Doe Jr.", bibliotecarioDAOList.findById(1).getName());
    }

    @Test
    public void testDelete() {
        bibliotecarioDAOList.delete(bibliotecarioDAOList.findById(1));
        assertNull(bibliotecarioDAOList.findById(1));
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
        assertEquals("johndoe", bibliotecarioDAOList.findById(1).getUsername());
    }
}
