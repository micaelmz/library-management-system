package thejoseviictor.biblioteca.dao.emprestados;

import thejoseviictor.biblioteca.model.Emprestados;

import java.util.List;

public interface EmprestadosDAO {
    public Emprestados criar(Emprestados objeto);
    public List<Emprestados> lerTodos();
    public Emprestados encontrarEmprestado(Emprestados objeto);
    public Emprestados atualizar(Emprestados objeto);
    public void deletar(Emprestados objeto);
    public void deletarTodos();
}
