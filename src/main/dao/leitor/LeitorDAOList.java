package main.dao.leitor;

import main.model.Leitor;
import main.model.Livro;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para leitores</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Leitor
 * @see main.dao.leitor.LeitorDAO
 */
public class LeitorDAOList implements LeitorDAO{
    private List<Leitor> listaLeitores;
    private Integer ultimoID = 0;


    public LeitorDAOList() {
        this.listaLeitores = new LinkedList<Leitor>();
    }

    /**
     * Método que cria um novo leitor
     * @param objeto objeto do leitor
     * @return objeto do leitor
     */
    @Override
    public Leitor criar(Leitor objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaLeitores.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
            listaLeitores.add(objeto);
        }
        return objeto;
    }

    /**
     * Método que retorna todos os leitores
     * @return lista de leitores
     */
    @Override
    public List<Leitor> lerTodos() {
        return listaLeitores;
    }

    /**
     * Método que retorna um leitor específico
     * @param objeto objeto do leitor
     * @return retorna um leitor específico
     */
    @Override
    public Leitor encontrarPorID(Integer id) {
        for (Leitor leitor : listaLeitores) {
            if (leitor.getId().equals(id)){
                return leitor;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um leitor específico
     * @param objeto objeto do leitor
     * @return objeto do leitor
     */
    @Override
    public Leitor atualizar(Leitor objeto) {
        if (listaLeitores.contains(objeto)){
            listaLeitores.set(listaLeitores.indexOf(objeto), objeto);
        }
        return objeto;
    }

    /**
     * Método que remove um leitor específico
     * @param objeto objeto do leitor
     */
    @Override
    public void deletar(Leitor objeto) {
        listaLeitores.remove(objeto);
    }

    /**
     * Método que remove todos os leitores
     */
    @Override
    public void deletarTodos() {
        listaLeitores.clear();
    }
}
