package main.model;

import main.GlobalData;

public class Usuario {
    private final Integer id;
    private String usuario;
    private String senha;
    private String nome;
    private Cargo cargo;

    public Usuario(Integer id, String usuario, String senha, String nome) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public Cargo getCargo() {
        return cargo;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean validaAcesso(String usuario, String senha) {
        if (this.usuario.equals(usuario) && this.senha.equals(senha)) {
            GlobalData.setUsuarioAtual(this);
            return true;
        }
        return false;
    }
}
