package main.dao.emprestimo;

import main.dao.leitor.LeitorDAO;
import main.model.Emprestimo;

import java.util.LinkedList;
import java.util.List;

public class EmprestimoDAOList implements EmprestimoDAO{
    private List<Emprestimo> listaEmprestimos;

    public EmprestimoDAOList() {
        this.listaEmprestimos = new LinkedList<Emprestimo>();
    }

    @Override
    public Emprestimo criar(Emprestimo objeto) {
        if (!listaEmprestimos.contains(objeto)){
            listaEmprestimos.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Emprestimo> lerTodos() {
        return listaEmprestimos;
    }

    @Override
    public Emprestimo encontrarEmprestimo(Emprestimo objeto) {
        int indice = listaEmprestimos.indexOf(objeto);
        if (indice != -1){
            return listaEmprestimos.get(indice);
        }
        return null;
    }

    @Override
    public Emprestimo atualizar(Emprestimo objeto) {
        int indice = listaEmprestimos.indexOf(objeto);
        if (indice != -1){
            listaEmprestimos.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    @Override
    public void deletar(Emprestimo objeto) {
        listaEmprestimos.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaEmprestimos.clear();
    }
}
