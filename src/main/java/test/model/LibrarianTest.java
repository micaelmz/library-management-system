package test.model;

import app.enums.BorrowingStatus;
import app.model.Book;
import app.model.Borrowing;
import app.model.Librarian;
import app.model.Reader;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class LibrarianTest {

    @Test
    public void testBorrow() {
        Librarian librarian = new Librarian(
                "joao1",
                "123456",
                "João"
        );
        Reader sampleReader = new Reader(
                "johndoe",
                "123456",
                "John Doe",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );
        Book sampleBook = new Book(
                "Lorem Ipsum",
                "John Doe",
                "12B34",
                1970,
                "Dolor",
                1,
                1
        );
        Borrowing borrowingTest = librarian.borrowBook(sampleReader, sampleBook, 1, 1);
        assertFalse(sampleBook.isAvailable());
        assertTrue(sampleReader.getBorrowingHistory().contains(borrowingTest));
        assertEquals(LocalDate.now().plusDays(1), borrowingTest.getDueDate());
        assertEquals(borrowingTest.getStatus(), BorrowingStatus.ACTIVE);
    }

    @Test
    public void testCreateReservation() {
        Librarian librarian = new Librarian(
                "joao1",
                "123456",
                "João"
        );
        Reader sampleReader1 = new Reader(
                "johndoe",
                "123456",
                "John Doe",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );
        Reader sampleReader2 = new Reader(
                "johndoe2",
                "123456",
                "John Doe2",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );
        Book sampleBook = new Book(
                "Lorem Ipsum",
                "John Doe",
                "12B34",
                1970,
                "Dolor",
                1,
                1
        );
        Borrowing borrowingTest1 = librarian.borrowBook(sampleReader1, sampleBook, 1, 1);
        assertEquals(borrowingTest1.getStatus(), BorrowingStatus.ACTIVE);
        Borrowing borrowingTest2 = librarian.borrowBook(sampleReader2, sampleBook, 1, 1);
        assertEquals(borrowingTest2.getStatus(), BorrowingStatus.RESERVED);
    }
}
