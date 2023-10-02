package main.dao.leitor;

import main.model.Leitor;

import java.util.List;

public interface LeitorDAO {
    public Leitor criar(Leitor objeto);
    public List<Leitor> lerTodos();
    public Leitor encontrarLeitor(Leitor objeto);
    public Leitor atualizar(Leitor objeto);
    public void deletar(Leitor objeto);
    public void deletarTodos();
}
