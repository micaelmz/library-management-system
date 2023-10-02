package test.dao;

import main.model.Usuario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import main.dao.usuario.UsuarioDAOList;

public class UsuarioDAOTest {

    UsuarioDAOList usuarioDAOList = new UsuarioDAOList();

    @Before
    public void setUp() {
        usuarioDAOList.criar(new Usuario("johndoe", "123456", "John Doe"));
        usuarioDAOList.criar(new Usuario("janedoe", "123456", "Jane Doe"));
    }
    @Test
    public void testEncontrarPorID() {
        assertEquals("johndoe", usuarioDAOList.encontrarPorID(1).getUsuario());
        assertEquals("janedoe", usuarioDAOList.encontrarPorID(2).getUsuario());
    }

    @Test
    public void testAtualizar() {
        Usuario usuario = usuarioDAOList.encontrarPorID(1);
        usuario.setNome("John Doe 2");
        usuarioDAOList.atualizar(usuario);
        assertEquals("John Doe 2", usuarioDAOList.encontrarPorID(1).getNome());
    }

    @Test
    public void testDeletar() {
        usuarioDAOList.deletar(usuarioDAOList.encontrarPorID(1));
        assertNull(usuarioDAOList.encontrarPorID(1));
    }

    @Test
    public void testDeletarTudo() {
        usuarioDAOList.deletarTodos();
        assertTrue(usuarioDAOList.lerTodos().isEmpty());
    }
}
