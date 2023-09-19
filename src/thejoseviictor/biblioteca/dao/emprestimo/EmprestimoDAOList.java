package thejoseviictor.biblioteca.dao.emprestimo;

import thejoseviictor.biblioteca.model.Emprestimo;

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
        for (Emprestimo percorrer : listaEmprestimos){
            if (percorrer.getLeitor().getId().equals(objeto.getLeitor().getId())){
                if(percorrer.getLivroID().equals(objeto.getLivroID())){
                    return percorrer;
                }
            }
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
