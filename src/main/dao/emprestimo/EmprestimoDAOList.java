package main.dao.emprestimo;

import main.dao.leitor.LeitorDAO;
import main.model.Emprestimo;
import main.model.Leitor;

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
    private Integer ultimoID = 0;

    public EmprestimoDAOList() {
        this.listaEmprestimos = new LinkedList<Emprestimo>();
    }

    /**
     * Método que cria um novo empréstimo
     * @param objeto objeto do empréstimo
     * @return objeto do empréstimo
     */
    @Override
    public Emprestimo criar(Emprestimo objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaEmprestimos.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
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
    public Emprestimo encontrarPorID(Integer id) {
        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.getId().equals(id)){
                return emprestimo;
            }
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
        if (listaEmprestimos.contains(objeto)){
            listaEmprestimos.set(listaEmprestimos.indexOf(objeto), objeto);
        }
        return objeto;
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
