package main.model;

import main.enums.Cargo;

public class Operadores extends Usuario{

    public Operadores(String usuario, String senha, String nome, Cargo cargo) {
        super(
            usuario,
            senha,
            nome
        );
        this.setCargo(cargo);
    }
}
