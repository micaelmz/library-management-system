package test.dao;

import app.dao.UtilityAllUsers;
import app.dao.UtilityDatFilesFolder;
import app.model.Reader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.dao.ReaderDAOList;

import java.io.IOException;

public class ReaderDAOTest {

    ReaderDAOList readerDAOList;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        UtilityDatFilesFolder.enableTestMode();
        readerDAOList = new ReaderDAOList();
        readerDAOList.create(new Reader("johndoe","123456","John Doe","St. Lorem Ipsum, 123","(99) 99999-9999"));
        readerDAOList.create(new Reader("janedoe","123456","Jane Doe","St. Lorem Ipsum, 123","(99) 99999-9999"));
    }

    @After
    public void tearDown() throws IOException {
        UtilityAllUsers.resetId();
        UtilityDatFilesFolder.disableTestMode();
    }

    @Test
    public void testFindById() {
        assertEquals("John Doe", readerDAOList.findById(0).getName());
        assertEquals("janedoe", readerDAOList.findById(1).getUsername());
    }

    @Test
    public void testUpdate() {
        Reader reader = readerDAOList.findById(0);
        reader.setName("John Doe Jr.");
        readerDAOList.update(reader);
        assertEquals("John Doe Jr.", readerDAOList.findById(0).getName());
    }

    @Test
    public void testDelete() {
        readerDAOList.delete(readerDAOList.findById(0));
        assertNull(readerDAOList.findById(0));
    }

    @Test
    public void testDeleteAll() {
        readerDAOList.deleteAll();
        assertTrue(readerDAOList.getAll().isEmpty());
    }

    @Test
    public void testDataPersistence() throws IOException, ClassNotFoundException {
        readerDAOList.saveDatFile();
        readerDAOList.deleteAll();
        readerDAOList.loadDatFile();
        assertFalse(readerDAOList.getAll().isEmpty());
    }
}
