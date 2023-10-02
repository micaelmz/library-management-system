package main.model;

import java.time.LocalDate;

public class Admin extends Operadores{
    public Admin(Integer id, String usuario, String senha, String cargo, String nome) {
        super(
            id,
            usuario,
            senha,
            nome,
            cargo
        );
    }

    public boolean banirLeitor(Leitor leitor, Integer diasBanido) {
        if (!leitor.isBanido()) {
            leitor.setBanidoAte(LocalDate.now().plusDays(diasBanido));
            return true;
        }
        return false;
    }
}
