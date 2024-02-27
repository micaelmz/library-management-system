package test.dao;

import app.dao.UtilityAllUsers;
import app.dao.UtilityDatFilesFolder;
import app.model.Borrowing;
import app.model.Reader;
import app.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.dao.BorrowingDAOList;

import java.io.IOException;

public class BorrowingDAOTest {

    BorrowingDAOList borrowingDAOList;

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        UtilityDatFilesFolder.enableTestMode();
        borrowingDAOList = new BorrowingDAOList();
        borrowingDAOList.create(
                new Borrowing(
                        new Reader(
                                "johndoe",
                                "123456",
                                "John Doe",
                                "St. Lorem Ipsum, 123",
                                "(99) 99999-9999"
                        ),
                        new Book(
                                "Lorem Ipsum",
                                "John Doe",
                                "12B34",
                                1970,
                                "Dolor",
                                1,
                                1
                        ),
                        1,
                        1
                )
        );
    }

    @After
    public void tearDown() throws IOException {
        UtilityAllUsers.resetId();
        borrowingDAOList.resetId();
        UtilityDatFilesFolder.disableTestMode();
    }

    @Test
    public void testFindById() {
        assertEquals("johndoe", borrowingDAOList.findById(0).getReader().getUsername());
    }

    @Test
    public void testUpdate() {
        Borrowing borrowing = borrowingDAOList.findById(0);
        borrowing.setRenewals(5);
        borrowingDAOList.update(borrowing);
        assertEquals(5, borrowingDAOList.findById(0).getRenewals().intValue());
    }

    @Test
    public void testDelete() {
        borrowingDAOList.delete(borrowingDAOList.findById(0));
        assertNull(borrowingDAOList.findById(0));
    }

    @Test
    public void testeDeleteAll() {
        borrowingDAOList.deleteAll();
        assertTrue(borrowingDAOList.getAll().isEmpty());
    }

    @Test
    public void testDataPersistence() throws IOException, ClassNotFoundException {
        borrowingDAOList.saveDatFile();
        borrowingDAOList.deleteAll();
        borrowingDAOList.loadDatFile();
        assertFalse(borrowingDAOList.getAll().isEmpty());
    }
}
