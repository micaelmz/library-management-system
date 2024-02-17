package test.dao;

import app.model.Borrowing;
import app.model.Reader;
import app.model.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.dao.borrowing.BorrowingDAOList;

import java.io.IOException;

public class BorrowingDAOTest {

    BorrowingDAOList borrowingDAOList = new BorrowingDAOList();

    @Before
    public void setUp() {
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

    @Test
    public void testFindById() {
        assertEquals("johndoe", borrowingDAOList.findById(1).getReader().getUsername());
    }

    @Test
    public void testUpdate() {
        Borrowing borrowing = borrowingDAOList.findById(1);
        borrowing.setRenewals(5);
        borrowingDAOList.update(borrowing);
        assertEquals(5, borrowingDAOList.findById(1).getRenewals().intValue());
    }

    @Test
    public void testDelete() {
        borrowingDAOList.delete(borrowingDAOList.findById(1));
        assertNull(borrowingDAOList.findById(1));
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
        assertEquals("johndoe", borrowingDAOList.findById(1).getReader().getUsername());
    }
}
