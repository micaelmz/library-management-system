package test.model;

import main.enums.StatusEmprestimo;
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
                "joao1",
                "123456",
                "João"
        );
        Leitor exemploLeitor = new Leitor(
                "johndoe",
                "123456",
                "John Doe",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );
        Livro exemploLivro = new Livro(
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
        assertTrue(exemploLeitor.getHistoricoEmprestimo().contains(emprestimoTest));
        assertEquals(LocalDate.now().plusDays(1), emprestimoTest.getDataEntrega());
        assertEquals(emprestimoTest.getStatus(), StatusEmprestimo.ATIVO);
    }

    @Test
    public void testarCriarReserva() {
        Bibliotecario bibliotecario = new Bibliotecario(
                "joao1",
                "123456",
                "João"
        );
        Leitor exemploLeitor1 = new Leitor(
                "johndoe",
                "123456",
                "John Doe",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );
        Leitor exemploLeitor2 = new Leitor(
                "johndoe2",
                "123456",
                "John Doe2",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );
        Livro exemploLivro = new Livro(
                "Lorem Ipsum",
                "John Doe",
                "12B34",
                1970,
                "Dolor",
                1,
                1
        );
        Emprestimo emprestimoTest1 = bibliotecario.criarEmprestimo(exemploLeitor1, exemploLivro, 1, 1);
        assertEquals(emprestimoTest1.getStatus(), StatusEmprestimo.ATIVO);
        Emprestimo emprestimoTest2 = bibliotecario.criarEmprestimo(exemploLeitor2, exemploLivro, 1, 1);
        assertEquals(emprestimoTest2.getStatus(), StatusEmprestimo.RESERVADO);
    }
}
