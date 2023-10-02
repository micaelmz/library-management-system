package test.model;

import main.model.Admin;
import main.model.Leitor;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class AdminTest {

    @Test
    public void testBanirLeitor() {
        Admin admin = new Admin(
                "joao1",
                "123456",
                "João"
        );

        Leitor leitor = new Leitor(
                "johndoe",
                "123456",
                "John Doe",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );

        admin.banirLeitor(leitor, 7);
        assertTrue(leitor.isBanido());
        assertEquals(LocalDate.now().plusDays(7), leitor.getBanidoAte());
    }
}
