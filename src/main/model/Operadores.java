package main.model;

public class Operadores extends Usuario{

    public Operadores(Integer id, String usuario, String senha, String nome, Cargo cargo) {
        super(
            id,
            usuario,
            senha,
            nome
        );
        this.setCargo(cargo);
    }
}
