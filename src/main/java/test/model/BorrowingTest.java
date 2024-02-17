package test.model;

import app.model.Borrowing;
import app.model.Reader;
import app.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BorrowingTest {

    Borrowing borrowing1;
    Borrowing borrowing2;
    Borrowing borrowing3;

    @Before
    public void borrow() {
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

        borrowing1 = new Borrowing(
                sampleReader,
                sampleBook,
                1,
                1
        );

        borrowing2 = new Borrowing(
                sampleReader,
                sampleBook,
                0,
                1
        );

        borrowing3 = new Borrowing(
                sampleReader,
                sampleBook,
                -1,
                1
        );
    }

    @Test
    public void testDueDate() {
        assertEquals(LocalDate.now().plusDays(1), borrowing1.getDueDate());
        assertEquals(LocalDate.now(), borrowing2.getDueDate());
        assertEquals(LocalDate.now().minusDays(1), borrowing3.getDueDate());
    }

    @Test
    public void testOverDue() {
        assertFalse(borrowing1.isOverdue());
        assertFalse(borrowing2.isOverdue());
        assertTrue(borrowing3.isOverdue());
    }

    @Test
    public void testRenew() {
        borrowing1.setDueDate(LocalDate.now());
        borrowing1.setLoanDays(3);
        borrowing1.setRenewals(1);
        boolean renovado = borrowing1.renew();

        int renovacoesDisponiveis = borrowing1.getRenewals();
        LocalDate novaDataEntrega = borrowing1.getDueDate();

        assertTrue(renovado);
        assertEquals(0, renovacoesDisponiveis);
        assertEquals(LocalDate.now().plusDays(3), novaDataEntrega);
    }

    @Test
    public void testBookReturnAndPenalty(){
        // usando emprestimo3, que tem 1 dia de atraso
        Book book = borrowing3.getBook();
        Boolean returned = borrowing3.returnBook();
        Reader reader = borrowing3.getReader();

        assertTrue(returned);
        assertTrue(reader.isBanned());
        assertEquals(LocalDate.now().plusDays(2), reader.getBannedUntil());
        assertTrue(book.isAvailable());
    }
}
