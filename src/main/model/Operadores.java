package main.model;

public class Operadores extends Usuario{
    private String cargo;

    public Operadores(Integer id, String usuario, String senha, String nome, String cargo) {
        super(
            id,
            usuario,
            senha,
            nome
        );
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
