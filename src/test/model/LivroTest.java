package test.model;

import main.model.Livro;
import org.junit.Test;
import static org.junit.Assert.*;

public class LivroTest {

    Livro exemploLivro = new Livro(
            1,
            "Lorem Ipsum",
            "John Doe",
            "12B34",
            1970,
            "Dolor",
            1,
            1
    );

    @Test
    public void testarDisponibilidade() {
        assertTrue(exemploLivro.isDisponivel());
        exemploLivro.decrementar();
        assertFalse(exemploLivro.isDisponivel());
    }
}
