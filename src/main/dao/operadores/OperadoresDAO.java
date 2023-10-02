package main.dao.operadores;

import main.model.Operadores;

import java.util.List;

public interface OperadoresDAO {
    public Operadores criar(Operadores objeto);
    public List<Operadores> lerTodos();
    public Operadores encontrarPorID(Integer id);
    public Operadores atualizar(Operadores objeto);
    public void deletar(Operadores objeto);
    public void deletarTodos();
}
