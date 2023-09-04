package thejoseviictor.biblioteca.model;

public class Admin extends Operadores{
    private String nome;

    public Admin(String usuario, String senha, Integer id, String cargo, String nome) {
        super(usuario, senha, id, cargo);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
