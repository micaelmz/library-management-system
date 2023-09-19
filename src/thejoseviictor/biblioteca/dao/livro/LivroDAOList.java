package thejoseviictor.biblioteca.dao.livro;

import thejoseviictor.biblioteca.model.Livro;

import java.util.LinkedList;
import java.util.List;

public class LivroDAOList implements LivroDAO{
    private List<Livro> listaLivros;

    public LivroDAOList() {
        this.listaLivros = new LinkedList<Livro>();
    }

    @Override
    public Livro criar(Livro objeto) {
        if (!listaLivros.contains(objeto)){
            listaLivros.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Livro> lerTodos() {
        return listaLivros;
    }

    @Override
    public Livro encontrarLivro(Livro objeto) {
        for (Livro percorrer : listaLivros){
            if (percorrer.getId().equals(objeto.getId())){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Livro atualizar(Livro objeto) {
        int indice = listaLivros.indexOf(objeto);
        if (indice != -1){
            listaLivros.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    @Override
    public void deletar(Livro objeto) {
        listaLivros.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaLivros.clear();
    }
}
