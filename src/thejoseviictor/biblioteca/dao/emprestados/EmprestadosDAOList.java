package thejoseviictor.biblioteca.dao.emprestados;

import thejoseviictor.biblioteca.model.Emprestados;

import java.util.LinkedList;
import java.util.List;

public class EmprestadosDAOList implements EmprestadosDAO{
    private List<Emprestados> listaEmprestados;

    public EmprestadosDAOList() {
        this.listaEmprestados = new LinkedList<Emprestados>();
    }

    @Override
    public Emprestados criar(Emprestados objeto) {
        if (!listaEmprestados.contains(objeto)){
            listaEmprestados.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Emprestados> lerTodos() {
        return listaEmprestados;
    }

    @Override
    public Emprestados encontrarEmprestado(Emprestados objeto) {
        for (Emprestados percorrer : listaEmprestados){
            if (percorrer.getLivro().getId().equals(objeto.getLivro().getId())){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Emprestados atualizar(Emprestados objeto) {
        int indice = listaEmprestados.indexOf(objeto);
        if (indice != -1){
            listaEmprestados.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    @Override
    public void deletar(Emprestados objeto) {
        listaEmprestados.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaEmprestados.clear();
    }
}
