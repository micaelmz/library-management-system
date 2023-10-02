package test.model;

import main.model.Bibliotecario;
import main.model.Emprestimo;
import main.model.Leitor;
import main.model.Livro;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BibliotecarioTest {

    @Test
    public void testarCriarEmprestimo() {
        Bibliotecario bibliotecario = new Bibliotecario(
                1,
                "joao1",
                "123456",
                "João"
        );
        Leitor exemploLeitor = new Leitor(
                1,
                "johndoe",
                "123456",
                "John Doe",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );
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
        Emprestimo emprestimoTest = bibliotecario.criarEmprestimo(exemploLeitor, exemploLivro, 1, 1);
        assertFalse(exemploLivro.isDisponivel());
        assertTrue(exemploLeitor.getEmprestimos().contains(emprestimoTest));
        assertEquals(LocalDate.now().plusDays(1), emprestimoTest.getDataEntrega());
    }
}
