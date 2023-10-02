package main.dao.usuario;

import main.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public Usuario criar(Usuario objeto);
    public List<Usuario> lerTodos();
    public Usuario encontrarUsuario(Usuario objeto);
    public Usuario atualizar(Usuario objeto);
    public void deletar(Usuario objeto);
    public void deletarTodos();
}
