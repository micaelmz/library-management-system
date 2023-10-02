package main.model;

import main.enums.Cargo;

import java.time.LocalDate;

public class Admin extends Operadores{
    public Admin(String usuario, String senha, String nome) {
        super(
            usuario,
            senha,
            nome,
            Cargo.ADMIN
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
