package main.dao.bibliotecario;

import main.model.Bibliotecario;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para bibliotecários</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Bibliotecario
 * @see main.dao.bibliotecario.BibliotecarioDAO
 */
public class BibliotecarioDAOList implements BibliotecarioDAO{
    private List<Bibliotecario> listaBibliotecarios;

    public BibliotecarioDAOList() {
        this.listaBibliotecarios = new LinkedList<Bibliotecario>();
    }

    /**
     * Método que cria um novo bibliotecário
     * @param objeto objeto do bibliotecário
     * @return objeto do bibliotecário
     */
    @Override
    public Bibliotecario criar(Bibliotecario objeto) {
        if (!listaBibliotecarios.contains(objeto)){
            listaBibliotecarios.add(objeto);
        }
        return objeto;
    }

    /**
     * Método que retorna todos os bibliotecários
     * @return lista de bibliotecários
     */
    @Override
    public List<Bibliotecario> lerTodos() {
        return listaBibliotecarios;
    }

    /**
     * Método que retorna um bibliotecário específico
     * @param objeto objeto do bibliotecário
     * @return retorna um bibliotecário específico
     */
    @Override
    public Bibliotecario encontrarBibliotecario(Bibliotecario objeto) {
        for (Bibliotecario percorrer : listaBibliotecarios){
            if (percorrer.getNome().equalsIgnoreCase(objeto.getNome())){
                return percorrer;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um bibliotecário específico
     * @param objeto objeto do bibliotecário
     * @return objeto do bibliotecário
     */
    @Override
    public Bibliotecario atualizar(Bibliotecario objeto) {
        int indice = listaBibliotecarios.indexOf(objeto);
        if (indice != -1){
            listaBibliotecarios.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    /**
     * Método que remove um bibliotecário específico
     * @param objeto objeto do bibliotecário
     */
    @Override
    public void deletar(Bibliotecario objeto) {
        listaBibliotecarios.remove(objeto);
    }

    /**
     * Método que remove todos os bibliotecários
     */
    @Override
    public void deletarTodos() {
        listaBibliotecarios.clear();
    }
}
