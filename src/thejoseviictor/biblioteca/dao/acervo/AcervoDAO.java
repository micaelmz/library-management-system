package thejoseviictor.biblioteca.dao.acervo;

import thejoseviictor.biblioteca.model.Acervo;

import java.util.List;

public interface AcervoDAO {
    public Acervo criar(Acervo objeto);
    public List<Acervo> lerTodos();
    public Acervo encontrarAcervo(Acervo objeto);
    public Acervo atualizar(Acervo objeto);
    public void deletar(Acervo objeto);
    public void deletarTodos();
}
