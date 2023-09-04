package thejoseviictor.biblioteca.model;

public class Operadores extends Usuario{
    private Integer id;
    private String cargo;

    public Operadores(String usuario, String senha, Integer id, String cargo) {
        super(usuario, senha);
        this.id = id;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
