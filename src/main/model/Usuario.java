package main.model;

import main.GlobalData;
import main.enums.Cargo;

/**
 * <b>Esta classe implementa os usuários do Sistema de Biblioteca e seus atributos</b>
 * Contendo as seguintes informações:
 * ID do Usuário (Integer);
 * Login de Usuário (String);
 * Senha do Usuário (String);
 * Nome Completo do Usuário (String);
 * Cargo do Usuário (Cargo).
 *
 * Exemplo de Uso:
 * Usuario usuario = new Usuario(id,"usuario", "senha", "nome");
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see Cargo
 */

public class Usuario {
    private Integer id;
    private String usuario;
    private String senha;
    private String nome;
    private Cargo cargo;

    public Usuario(String usuario, String senha, String nome) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que retorna o nome do usuário
     * @return nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que retorna o ID do usuário
     * @return ID do usuário
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que retorna o login do usuário
     * @return login do usuário
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que retorna a senha do usuário
     * @return senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Método que retorna o cargo do usuário
     * @return cargo do usuário
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * Método que modifica o nome do usuário
     * @param nome nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que modifica o login do usuário
     * @param usuario login do usuário
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que modifica a senha do usuário
     * @param senha senha do usuário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Método que modifica o cargo do usuário
     * @param cargo cargo do usuário
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * Método que valida o login e senha do usuário, permitindo a entrada do usuário ao sistema
     * @param usuario login do usuário
     * @param senha senha do usuário
     * @return dados corretos ou incorretos (true ou false)
     */
    public boolean validaAcesso(String usuario, String senha) {
        if (this.usuario.equals(usuario) && this.senha.equals(senha)) {
            GlobalData.setUsuarioAtual(this);
            return true;
        }
        return false;
    }
}
