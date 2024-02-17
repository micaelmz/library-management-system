package test.model;

import app.model.Book;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    Book sampleBook = new Book(
            "Lorem Ipsum",
            "John Doe",
            "12B34",
            1970,
            "Dolor",
            1,
            1
    );

    @Test
    public void testAvailability() {
        assertTrue(sampleBook.isAvailable());
        sampleBook.setQuantity(0);
        assertFalse(sampleBook.isAvailable());
    }
}
