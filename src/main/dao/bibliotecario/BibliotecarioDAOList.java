package main.dao.bibliotecario;

import main.model.Bibliotecario;
import main.model.Emprestimo;

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
    private Integer ultimoID = 0;

    public BibliotecarioDAOList() {
        this.listaBibliotecarios = new LinkedList<Bibliotecario>();
    }

    /**
     * Método que cria um novo bibliotecário
     * @param objeto objeto do bibliotecário
     * @return objeto do bibliotecário
     */
    @Override
    public Bibliotecario criar(Bibliotecario objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaBibliotecarios.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
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
     * @param id objeto do bibliotecário
     * @return retorna um bibliotecário específico
     */
    @Override
    public Bibliotecario encontrarPorID(Integer id) {
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            if (bibliotecario.getId().equals(id)){
                return bibliotecario;
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
        if (listaBibliotecarios.contains(objeto)){
            listaBibliotecarios.set(listaBibliotecarios.indexOf(objeto), objeto);
        }
        return objeto;
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
