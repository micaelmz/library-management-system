package test.dao;

import app.model.Emprestimo;
import app.model.Leitor;
import app.model.Livro;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.dao.emprestimo.EmprestimoDAOList;

import java.io.IOException;

public class EmprestimoDAOTest {

    EmprestimoDAOList emprestimoDAOList = new EmprestimoDAOList();

    @Before
    public void setUp() {
        emprestimoDAOList.criar(
                new Emprestimo(
                        new Leitor(
                                "johndoe",
                                "123456",
                                "John Doe",
                                "St. Lorem Ipsum, 123",
                                "(99) 99999-9999"
                        ),
                        new Livro(
                                "Lorem Ipsum",
                                "John Doe",
                                "12B34",
                                1970,
                                "Dolor",
                                1,
                                1
                        ),
                        1,
                        1
                )
        );
    }

    @Test
    public void testEncontrarPorID() {
        assertEquals("johndoe", emprestimoDAOList.encontrarPorID(1).getLeitor().getUsuario());
    }

    @Test
    public void testAtualizar() {
        Emprestimo emprestimo = emprestimoDAOList.encontrarPorID(1);
        emprestimo.setRenovacoes(5);
        emprestimoDAOList.atualizar(emprestimo);
        assertEquals(5, emprestimoDAOList.encontrarPorID(1).getRenovacoes().intValue());
    }

    @Test
    public void testDeletar() {
        emprestimoDAOList.deletar(emprestimoDAOList.encontrarPorID(1));
        assertNull(emprestimoDAOList.encontrarPorID(1));
    }

    @Test
    public void testDeletarTudo() {
        emprestimoDAOList.deletarTodos();
        assertTrue(emprestimoDAOList.lerTodos().isEmpty());
    }

    @Test
    public void testArquivos() throws IOException, ClassNotFoundException {
        emprestimoDAOList.salvarArquivo();
        emprestimoDAOList.deletarTodos();
        emprestimoDAOList.carregarArquivo();
        assertEquals("johndoe", emprestimoDAOList.encontrarPorID(1).getLeitor().getUsuario());
    }
}
