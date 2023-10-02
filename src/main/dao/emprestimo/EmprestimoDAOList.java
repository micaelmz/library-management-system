package main.dao.emprestimo;

import main.dao.leitor.LeitorDAO;
import main.model.Emprestimo;
import main.model.Leitor;

import java.util.LinkedList;
import java.util.List;

public class EmprestimoDAOList implements EmprestimoDAO{
    private List<Emprestimo> listaEmprestimos;
    private Integer ultimoID = 0;

    public EmprestimoDAOList() {
        this.listaEmprestimos = new LinkedList<Emprestimo>();
    }

    @Override
    public Emprestimo criar(Emprestimo objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaEmprestimos.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
            listaEmprestimos.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Emprestimo> lerTodos() {
        return listaEmprestimos;
    }

    @Override
    public Emprestimo encontrarPorID(Integer id) {
        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.getId().equals(id)){
                return emprestimo;
            }
        }
        return null;
    }

    @Override
    public Emprestimo atualizar(Emprestimo objeto) {
        if (listaEmprestimos.contains(objeto)){
            listaEmprestimos.set(listaEmprestimos.indexOf(objeto), objeto);
        }
        return objeto;
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
