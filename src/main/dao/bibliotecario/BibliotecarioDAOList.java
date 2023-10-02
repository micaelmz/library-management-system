package main.dao.bibliotecario;

import main.model.Bibliotecario;
import main.model.Emprestimo;

import java.util.LinkedList;
import java.util.List;

public class BibliotecarioDAOList implements BibliotecarioDAO{
    private List<Bibliotecario> listaBibliotecarios;
    private Integer ultimoID = 0;

    public BibliotecarioDAOList() {
        this.listaBibliotecarios = new LinkedList<Bibliotecario>();
    }

    @Override
    public Bibliotecario criar(Bibliotecario objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaBibliotecarios.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
            listaBibliotecarios.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Bibliotecario> lerTodos() {
        return listaBibliotecarios;
    }

    @Override
    public Bibliotecario encontrarPorID(Integer id) {
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            if (bibliotecario.getId().equals(id)){
                return bibliotecario;
            }
        }
        return null;
    }

    @Override
    public Bibliotecario atualizar(Bibliotecario objeto) {
        if (listaBibliotecarios.contains(objeto)){
            listaBibliotecarios.set(listaBibliotecarios.indexOf(objeto), objeto);
        }
        return objeto;
    }

    @Override
    public void deletar(Bibliotecario objeto) {
        listaBibliotecarios.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaBibliotecarios.clear();
    }
}
