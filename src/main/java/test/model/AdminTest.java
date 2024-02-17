package test.model;

import app.model.Admin;
import app.model.Reader;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class AdminTest {

    @Test
    public void testBanReader() {
        Admin admin = new Admin(
                "joao1",
                "123456",
                "João"
        );

        Reader reader = new Reader(
                "johndoe",
                "123456",
                "John Doe",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );

        admin.banReader(reader, 7);
        assertTrue(reader.isBanned());
        assertEquals(LocalDate.now().plusDays(7), reader.getBannedUntil());
    }
}
