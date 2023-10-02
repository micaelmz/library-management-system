package main.dao.livro;

import main.model.Livro;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para livros</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Livro
 * @see main.dao.livro.LivroDAO
 */
public class LivroDAOList implements LivroDAO{
    private List<Livro> listaLivros;

    public LivroDAOList() {
        this.listaLivros = new LinkedList<Livro>();
    }

    /**
     * Método que cria um novo livro
     * @param objeto objeto do livro
     * @return objeto do livro
     */
    @Override
    public Livro criar(Livro objeto) {
        if (!listaLivros.contains(objeto)){
            listaLivros.add(objeto);
        }
        return objeto;
    }

    /**
     * Método que retorna todos os livros
     * @return lista de livros
     */
    @Override
    public List<Livro> lerTodos() {
        return listaLivros;
    }

    /**
     * Método que retorna um livro específico
     * @param objeto objeto do livro
     * @return retorna um livro específico
     */
    @Override
    public Livro encontrarLivro(Livro objeto) {
        for (Livro percorrer : listaLivros){
            if (percorrer.getId().equals(objeto.getId())){
                return percorrer;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um livro específico
     * @param objeto objeto do livro
     * @return objeto do livro
     */
    @Override
    public Livro atualizar(Livro objeto) {
        int indice = listaLivros.indexOf(objeto);
        if (indice != -1){
            listaLivros.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    /**
     * Método que remove um livro específico
     * @param objeto objeto do livro
     */
    @Override
    public void deletar(Livro objeto) {
        listaLivros.remove(objeto);
    }

    /**
     * Método que remove todos os livros
     */
    @Override
    public void deletarTodos() {
        listaLivros.clear();
    }
}
