package test.dao;

import main.model.Admin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import main.dao.admin.AdminDAOList;

public class AdminDAOTest {

    AdminDAOList adminDAOList = new AdminDAOList();

    @Before
    public void setUp() {
        adminDAOList.criar(new Admin("johndoe","123456","John Doe"));
        adminDAOList.criar(new Admin("janedoe","123456","Jane Doe"));
    }

    @Test
    public void testEncontrarPorID() {
        assertEquals("janedoe", adminDAOList.encontrarPorID(2).getUsuario());
        assertEquals("John Doe", adminDAOList.encontrarPorID(1).getNome());
    }

    @Test
    public void testAtualizar() {
        Admin admin = adminDAOList.encontrarPorID(1);
        admin.setNome("John Doe Jr.");
        adminDAOList.atualizar(admin);
        assertEquals("John Doe Jr.", adminDAOList.encontrarPorID(1).getNome());
    }

    @Test
    public void testDeletar() {
        adminDAOList.deletar(adminDAOList.encontrarPorID(1));
        assertNull(adminDAOList.encontrarPorID(1));
    }

    @Test
    public void testDeletarTodos() {
        adminDAOList.deletarTodos();
        assertTrue(adminDAOList.lerTodos().isEmpty());
    }
}
