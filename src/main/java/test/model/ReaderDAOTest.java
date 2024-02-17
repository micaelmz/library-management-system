package test.model;

import app.model.Reader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.dao.reader.ReaderDAOList;

public class ReaderDAOTest {

    ReaderDAOList readerDAOList = new ReaderDAOList();

    @Before
    public void setUp() {
        readerDAOList.create(new Reader("johndoe","123456","John Doe","St. Lorem Ipsum, 123","(99) 99999-9999"));
        readerDAOList.create(new Reader("janedoe","123456","Jane Doe","St. Lorem Ipsum, 123","(99) 99999-9999"));
    }

    @Test
    public void testFindById() {
        assertEquals("janedoe", readerDAOList.findById(2).getUsername());
        assertEquals("John Doe", readerDAOList.findById(1).getName());
    }

    @Test
    public void testUpdate() {
        Reader reader = readerDAOList.findById(1);
        reader.setName("John Doe Jr.");
        readerDAOList.update(reader);
        assertEquals("John Doe Jr.", readerDAOList.findById(1).getName());
    }

    @Test
    public void testDelete() {
        readerDAOList.delete(readerDAOList.findById(1));
        assertNull(readerDAOList.findById(1));
    }

    @Test
    public void testDeleteAll() {
        readerDAOList.deleteAll();
        assertTrue(readerDAOList.getAll().isEmpty());
    }
}
