package thejoseviictor.biblioteca.dao.bibliotecario;

import thejoseviictor.biblioteca.model.Bibliotecario;

import java.util.LinkedList;
import java.util.List;

public class BibliotecarioDAOList implements BibliotecarioDAO{
    private List<Bibliotecario> listaBibliotecarios;

    public BibliotecarioDAOList() {
        this.listaBibliotecarios = new LinkedList<Bibliotecario>();
    }

    @Override
    public Bibliotecario criar(Bibliotecario objeto) {
        if (!listaBibliotecarios.contains(objeto)){
            listaBibliotecarios.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Bibliotecario> lerTodos() {
        return listaBibliotecarios;
    }

    @Override
    public Bibliotecario encontrarBibliotecario(Bibliotecario objeto) {
        for (Bibliotecario percorrer : listaBibliotecarios){
            if (percorrer.getNome().equalsIgnoreCase(objeto.getNome())){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Bibliotecario atualizar(Bibliotecario objeto) {
        int indice = listaBibliotecarios.indexOf(objeto);
        if (indice != -1){
            listaBibliotecarios.set(indice, objeto);
            return objeto;
        }
        return null;
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
