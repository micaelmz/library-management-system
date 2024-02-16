package test;

import app.model.Usuario;
import app.GlobalData;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GlobalDataTest {

    @Before
    public void setUp() {
        Usuario usuarioExemplo = new Usuario("johndoe", "123456", "John Doe");
        usuarioExemplo.validaAcesso("johndoe", "123456");
    }

    @Test
    public void usuarioAtualLogado() {
        assertEquals("johndoe", GlobalData.getUsuarioAtual().getUsuario());
    }


}
