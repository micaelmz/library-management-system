package test;

import app.Report;
import app.dao.book.BookDAOList;
import app.model.Book;
import app.model.Reader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import app.model.Librarian;
import app.dao.reader.ReaderDAOList;
import app.dao.borrowing.BorrowingDAOList;

public class ReportTest {

    BorrowingDAOList borrowingDAOList = new BorrowingDAOList();
    ReaderDAOList readerDAOList = new ReaderDAOList();
    BookDAOList bookDAOList = new BookDAOList();
    Librarian librarian = new Librarian("bibliotecario", "123456", "Bibliotecário");
    Report report;

    @Before
    public void setUp() {
        bookDAOList.create(new Book("Livro 1", "Autor 1", "123B4", 1970, "Categoria 1", 5, 1));
        bookDAOList.create(new Book("Livro 2", "Autor 2", "123B5", 1970, "Categoria 1", 1, 1));
        bookDAOList.create(new Book("Livro 3", "Autor 3", "123B6", 1970, "Categoria 1", 2, 1));


        readerDAOList.create(new Reader("joao1", "12345678910", "João", "Rua 1", "123456789"));
        readerDAOList.create(new Reader("joao2", "12345678910", "João", "Rua 1", "123456789"));
        readerDAOList.create(new Reader("joao3", "12345678910", "João", "Rua 1", "123456789"));
        readerDAOList.create(new Reader("joao4", "12345678910", "João", "Rua 1", "123456789"));

        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(1), bookDAOList.findById(1), 7, 1));
        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(2), bookDAOList.findById(1), 7, 1));
        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(3), bookDAOList.findById(1), 7, 1));
        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(4), bookDAOList.findById(1), 7, 1));
        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(1), bookDAOList.findById(2), 7, 1));
        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(2), bookDAOList.findById(2), 7, 1));
        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(1), bookDAOList.findById(3), 7, 1));
        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(2), bookDAOList.findById(3), 7, 1));
        borrowingDAOList.create(librarian.borrowBook(readerDAOList.findById(3), bookDAOList.findById(3), 7, 1));

        report = new Report(borrowingDAOList, readerDAOList);
        report.generateBorrowingList();

        // Livro 1 emprestado 4 vezes, 1 para cada leitor
        // Livro 2 emprestado 1 vez e reservado 1 vez, para o leitor 1 e 2 respectivamente
        // Livro 3 emprestado 2 vezes e reservado 1 vez, para o leitor 1, 2 e 3 respectivamente
    }

    @After
    public void tearDown() {
        borrowingDAOList.deleteAll();
        readerDAOList.deleteAll();
        bookDAOList.deleteAll();
        report = null;
    }

    @Test
    public void testBorrowing(){
        assertEquals(7, report.getBorrowings().size());
    }

    @Test
    public void testReservations(){
        assertEquals(2, report.getReservedBooks().size());
    }

    @Test
    public void testOverdueBooks(){
        assertEquals(0, report.getOverDueBooks().size());
    }

    @Test
    public void testBorrowingQuantityByReader(){
        assertEquals(3, report.getBorrowingQuantityByReader(1).intValue());
        assertEquals(3, report.getBorrowingQuantityByReader(2).intValue());
        assertEquals(2, report.getBorrowingQuantityByReader(3).intValue());
        assertEquals(1, report.getBorrowingQuantityByReader(4).intValue());
    }

    @Test
    public void testHotBooks(){
        assertEquals(3, report.getHotBooks().size());
        assertEquals("Livro 1", report.getHotBooks().get(0).getTitle());
        assertEquals("Livro 3", report.getHotBooks().get(1).getTitle());
        assertEquals("Livro 2", report.getHotBooks().get(2).getTitle());
    }
}