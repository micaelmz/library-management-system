package app.model;

import app.enums.Role;

import java.io.Serializable;

/**
 * <b>Esta classe implementa os usuários do Sistema de Biblioteca e seus atributos</b>
 * Contendo as seguintes informações:
 * ID do Usuário (Integer);
 * Login de Usuário (String);
 * Senha do Usuário (String);
 * Nome Completo do Usuário (String);
 * Cargo do Usuário (Cargo).
 * <p>
 * Exemplo de Uso:
 * Usuario usuario = new Usuario("usuario", "senha", "nome");
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see Role
 */

public class BaseUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Role role;

    public BaseUser(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que retorna o nome do usuário
     *
     * @return nome do usuário
     */
    public String getName() {
        return name;
    }

    /**
     * Método que retorna o ID do usuário
     *
     * @return ID do usuário
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que retorna o login do usuário
     *
     * @return login do usuário
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método que retorna a senha do usuário
     *
     * @return senha do usuário
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método que retorna o cargo do usuário
     *
     * @return cargo do usuário
     */
    public Role getRole() {
        return role;
    }

    /**
     * Método que modifica o nome do usuário
     *
     * @param name nome do usuário
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que modifica o login do usuário
     *
     * @param username login do usuário
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método que modifica a senha do usuário
     *
     * @param password senha do usuário
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método que modifica o cargo do usuário
     *
     * @param role cargo do usuário
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Método que valida o login e senha do usuário, permitindo a entrada do usuário ao sistema
     *
     * @param username login do usuário
     * @param password senha do usuário
     * @return dados corretos ou incorretos (true ou false)
     */
    public boolean checkCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
