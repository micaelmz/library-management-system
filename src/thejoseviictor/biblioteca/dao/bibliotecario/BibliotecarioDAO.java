package thejoseviictor.biblioteca.dao.bibliotecario;

import thejoseviictor.biblioteca.model.Bibliotecario;

import java.util.List;

public interface BibliotecarioDAO {
    public Bibliotecario criar(Bibliotecario objeto);
    public List<Bibliotecario> lerTodos();
    public Bibliotecario encontrarBibliotecario(Bibliotecario objeto);
    public Bibliotecario atualizar(Bibliotecario objeto);
    public void deletar(Bibliotecario objeto);
    public void deletarTodos();
}
