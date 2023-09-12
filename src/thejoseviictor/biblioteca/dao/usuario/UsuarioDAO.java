package thejoseviictor.biblioteca.dao.usuario;

import thejoseviictor.biblioteca.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public Usuario criar(Usuario objeto);
    public List<Usuario> lerTodos();
    public Usuario encontrarUsuario(String usuario);
    public Usuario atualizar(Usuario objeto);
    public void deletar(Usuario objeto);
    public void deletarTodos();
}
