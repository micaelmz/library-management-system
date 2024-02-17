package test.model;

import app.model.BaseUser;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaseUserTest {

    @Test
    public void testCheckCredentials() {
        BaseUser baseUser = new BaseUser(
            "joao1",
            "123456",
            "João"
        );
        assertTrue(baseUser.checkCredentials("joao1", "123456"));
    }
}
