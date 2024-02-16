package test.model;

import app.model.Livro;
import org.junit.Test;
import static org.junit.Assert.*;

public class LivroTest {

    Livro exemploLivro = new Livro(
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
        exemploLivro.setQuantidade(0);
        assertFalse(exemploLivro.isDisponivel());
    }
}
