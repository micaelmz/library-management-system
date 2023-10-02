package main.dao.leitor;

import main.model.Leitor;

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

    public LeitorDAOList() {
        this.listaLeitores = new LinkedList<Leitor>();
    }

    /**
     * Método que cria um novo leitor
     * @param objeto objeto do leitor
     * @return objeto do leitor
     */
    @Override
    public Leitor criar(Leitor objeto) {
        if (!listaLeitores.contains(objeto)){
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
    public Leitor encontrarLeitor(Leitor objeto) {
        for (Leitor percorrer : listaLeitores){
            if (percorrer.getId().equals(objeto.getId())){
                return percorrer;
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
        int indice = listaLeitores.indexOf(objeto);
        if (indice != -1){
            listaLeitores.set(indice, objeto);
            return objeto;
        }
        return null;
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
