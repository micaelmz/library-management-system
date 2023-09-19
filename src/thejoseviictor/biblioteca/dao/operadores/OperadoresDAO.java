package thejoseviictor.biblioteca.dao.operadores;

import thejoseviictor.biblioteca.model.Operadores;

import java.util.List;

public interface OperadoresDAO {
    public Operadores criar(Operadores objeto);
    public List<Operadores> lerTodos();
    public Operadores encontrarOperador(Operadores objeto);
    public Operadores atualizar(Operadores objeto);
    public void deletar(Operadores objeto);
    public void deletarTodos();
}
