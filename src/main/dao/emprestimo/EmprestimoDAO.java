package main.dao.emprestimo;

import main.model.Emprestimo;

import java.util.List;

public interface EmprestimoDAO {
    public Emprestimo criar(Emprestimo objeto);
    public List<Emprestimo> lerTodos();
    public Emprestimo encontrarPorID(Integer id);
    public Emprestimo atualizar(Emprestimo objeto);
    public void deletar(Emprestimo objeto);
    public void deletarTodos();
}
