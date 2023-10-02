package main.dao.livro;

import main.model.Livro;
import main.model.Operadores;

import java.util.LinkedList;
import java.util.List;

public class LivroDAOList implements LivroDAO{
    private List<Livro> listaLivros;
    private Integer ultimoID = 0;

    public LivroDAOList() {
        this.listaLivros = new LinkedList<Livro>();
    }

    @Override
    public Livro criar(Livro objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaLivros.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
            listaLivros.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Livro> lerTodos() {
        return listaLivros;
    }

    @Override
    public Livro encontrarPorID(Integer id) {
        for (Livro livro : listaLivros) {
            if (livro.getId().equals(id)){
                return livro;
            }
        }
        return null;
    }

    @Override
    public Livro atualizar(Livro objeto) {
        if (listaLivros.contains(objeto)){
            listaLivros.set(listaLivros.indexOf(objeto), objeto);
        }
        return objeto;
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
