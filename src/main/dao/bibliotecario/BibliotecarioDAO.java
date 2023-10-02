package main.dao.bibliotecario;

import main.model.Bibliotecario;

import java.util.List;

public interface BibliotecarioDAO {
    public Bibliotecario criar(Bibliotecario objeto);
    public List<Bibliotecario> lerTodos();
    public Bibliotecario encontrarPorID(Integer id);
    public Bibliotecario atualizar(Bibliotecario objeto);
    public void deletar(Bibliotecario objeto);
    public void deletarTodos();
}
