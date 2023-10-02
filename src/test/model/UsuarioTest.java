package test.model;

import main.model.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void testValidaAcesso() {
        Usuario usuario = new Usuario(
            "joao1",
            "123456",
            "João"
        );
        assertTrue(usuario.validaAcesso("joao1", "123456"));
    }
}
