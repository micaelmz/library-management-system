package thejoseviictor.biblioteca.model;

public class Usuario {
    private String usuario;
    private String senha;

    private String email;

    public Usuario(String usuario, String senha, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }

    /*
    public boolean validaAcesso() {
        return
    }
    */

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String setEmail() {
        return email;
    }

    public void getEmail(String email) {
        this.email = email;
    }
}
