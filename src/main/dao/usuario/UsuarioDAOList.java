package main.dao.usuario;

import main.model.Usuario;

import java.util.LinkedList;
import java.util.List;

public class UsuarioDAOList implements UsuarioDAO{
    private List<Usuario> listaUsuarios;
    private Integer ultimoID = 0;

    public UsuarioDAOList() {
        this.listaUsuarios = new LinkedList<Usuario>();
    }

    @Override
    public Usuario criar(Usuario objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaUsuarios.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
            listaUsuarios.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Usuario> lerTodos(){
        return listaUsuarios;
    }

    @Override
    public Usuario encontrarPorID(Integer id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public Usuario atualizar(Usuario objeto) {
        // Vai verificar se o objeto já existe na lista.
        if (listaUsuarios.contains(objeto)){
            listaUsuarios.set(listaUsuarios.indexOf(objeto), objeto);
        }
        return objeto;
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
