package main.dao.emprestimo;

import main.dao.leitor.LeitorDAO;
import main.model.Emprestimo;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para empréstimos</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Bibliotecario
 * @see main.dao.bibliotecario.BibliotecarioDAO
 */
public class EmprestimoDAOList implements EmprestimoDAO{
    private List<Emprestimo> listaEmprestimos;

    public EmprestimoDAOList() {
        this.listaEmprestimos = new LinkedList<Emprestimo>();
    }

    /**
     * Método que cria um novo empréstimo
     * @param objeto objeto do empréstimo
     * @return objeto do empréstimo
     */
    @Override
    public Emprestimo criar(Emprestimo objeto) {
        if (!listaEmprestimos.contains(objeto)){
            listaEmprestimos.add(objeto);
        }
        return objeto;
    }

    /**
     * Método que retorna todos os empréstimos
     * @return lista de empréstimos
     */
    @Override
    public List<Emprestimo> lerTodos() {
        return listaEmprestimos;
    }

    /**
     * Método que retorna um empréstimo específico
     * @param objeto objeto do empréstimo
     * @return retorna um empréstimo específico
     */
    @Override
    public Emprestimo encontrarEmprestimo(Emprestimo objeto) {
        int indice = listaEmprestimos.indexOf(objeto);
        if (indice != -1){
            return listaEmprestimos.get(indice);
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um empréstimo específico
     * @param objeto objeto do empréstimo
     * @return objeto do empréstimo
     */
    @Override
    public Emprestimo atualizar(Emprestimo objeto) {
        int indice = listaEmprestimos.indexOf(objeto);
        if (indice != -1){
            listaEmprestimos.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    /**
     * Método que remove um empréstimo específico
     * @param objeto objeto do empréstimo
     */
    @Override
    public void deletar(Emprestimo objeto) {
        listaEmprestimos.remove(objeto);
    }

    /**
     * Método que remove todos os empréstimos
     */
    @Override
    public void deletarTodos() {
        listaEmprestimos.clear();
    }
}
