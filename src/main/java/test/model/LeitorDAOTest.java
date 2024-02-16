package test.model;

import app.model.Leitor;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.dao.leitor.LeitorDAOList;

public class LeitorDAOTest {

    LeitorDAOList leitorDAOList = new LeitorDAOList();

    @Before
    public void setUp() {
        leitorDAOList.criar(new Leitor("johndoe","123456","John Doe","St. Lorem Ipsum, 123","(99) 99999-9999"));
        leitorDAOList.criar(new Leitor("janedoe","123456","Jane Doe","St. Lorem Ipsum, 123","(99) 99999-9999"));
    }

    @Test
    public void testEncontrarPorID() {
        assertEquals("janedoe", leitorDAOList.encontrarPorID(2).getUsuario());
        assertEquals("John Doe", leitorDAOList.encontrarPorID(1).getNome());
    }

    @Test
    public void testAtualizar() {
        Leitor leitor = leitorDAOList.encontrarPorID(1);
        leitor.setNome("John Doe Jr.");
        leitorDAOList.atualizar(leitor);
        assertEquals("John Doe Jr.", leitorDAOList.encontrarPorID(1).getNome());
    }

    @Test
    public void testDeletar() {
        leitorDAOList.deletar(leitorDAOList.encontrarPorID(1));
        assertNull(leitorDAOList.encontrarPorID(1));
    }

    @Test
    public void testDeletarTodos() {
        leitorDAOList.deletarTodos();
        assertTrue(leitorDAOList.lerTodos().isEmpty());
    }
}
