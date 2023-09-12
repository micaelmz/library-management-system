package thejoseviictor.biblioteca.dao.usuario;

import thejoseviictor.biblioteca.model.Usuario;

import java.util.LinkedList;
import java.util.List;

public class UsuarioDAOList implements UsuarioDAO{
    private List<Usuario> listaUsuarios;

    public UsuarioDAOList() {
        this.listaUsuarios = new LinkedList<Usuario>();
    }

    @Override
    public Usuario criar(Usuario objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaUsuarios.contains(objeto)){
            listaUsuarios.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Usuario> lerTodos(){
        return listaUsuarios;
    }

    @Override
    public Usuario encontrarUsuario(String usuario) {
        for (Usuario percorrer : listaUsuarios){
            if (percorrer.getUsuario().equalsIgnoreCase(usuario)){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Usuario atualizar(Usuario objeto) {
        int indice = listaUsuarios.indexOf(objeto);
        // Vai verificar se o objeto está na lista.
        if (indice != -1){
            listaUsuarios.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    @Override
    public void deletar(Usuario objeto) {
        listaUsuarios.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaUsuarios.clear();
    }
}
