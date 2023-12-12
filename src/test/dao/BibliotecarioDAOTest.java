package test.dao;

import main.model.Bibliotecario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import main.dao.bibliotecario.BibliotecarioDAOList;

import java.io.IOException;

public class BibliotecarioDAOTest {

    BibliotecarioDAOList bibliotecarioDAOList = new BibliotecarioDAOList();

    @Before
    public void setUp() {
        bibliotecarioDAOList.criar(new Bibliotecario("johndoe","123456","John Doe"));
        bibliotecarioDAOList.criar(new Bibliotecario("janedoe","123456","Jane Doe"));
    }

    @Test
    public void testEncontrarPorID() {
        assertEquals("janedoe", bibliotecarioDAOList.encontrarPorID(2).getUsuario());
        assertEquals("John Doe", bibliotecarioDAOList.encontrarPorID(1).getNome());
    }

    @Test
    public void testAtualizar() {
        Bibliotecario bibliotecario = bibliotecarioDAOList.encontrarPorID(1);
        bibliotecario.setNome("John Doe Jr.");
        bibliotecarioDAOList.atualizar(bibliotecario);
        assertEquals("John Doe Jr.", bibliotecarioDAOList.encontrarPorID(1).getNome());
    }

    @Test
    public void testDeletar() {
        bibliotecarioDAOList.deletar(bibliotecarioDAOList.encontrarPorID(1));
        assertNull(bibliotecarioDAOList.encontrarPorID(1));
    }

    @Test
    public void testDeletarTodos() {
        bibliotecarioDAOList.deletarTodos();
        assertTrue(bibliotecarioDAOList.lerTodos().isEmpty());
    }

    @Test
    public void testArquivos() throws IOException, ClassNotFoundException {
        bibliotecarioDAOList.salvarArquivo();
        bibliotecarioDAOList.deletarTodos();
        bibliotecarioDAOList.carregarArquivo();
        assertEquals("johndoe", bibliotecarioDAOList.encontrarPorID(1).getUsuario());
    }
}
