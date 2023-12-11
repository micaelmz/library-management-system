package main.dao.emprestimo;

import main.model.Emprestimo;

import java.io.IOException;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para empréstimos</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Emprestimo
 */
public interface EmprestimoDAO {
    /**
     * Método que carrega os Emprestimos do arquivo binário "Emprestimos.dat" para a lista "listaEmprestimos".
     */
    public void carregarArquivo() throws IOException, ClassNotFoundException;

    /**
     * Método que salva os Emprestimos da lista "listaEmprestimos" para o arquivo binário "Emprestimos.dat".
     */
    public void salvarArquivo() throws IOException;

    /**
     * Método que cria um novo empréstimo
     * @param objeto objeto do empréstimo
     * @return objeto do empréstimo
     */
    public Emprestimo criar(Emprestimo objeto);

    /**
     * Método que retorna todos os empréstimos
     * @return lista de empréstimos
     */
    public List<Emprestimo> lerTodos();

    /**
     * Método que retorna um empréstimo específico
     * @param id objeto do empréstimo
     * @return retorna um empréstimo específico
     */
    public Emprestimo encontrarPorID(Integer id);

    /**
     * Método que atualiza os atributos de um empréstimo específico
     * @param objeto objeto do empréstimo
     * @return objeto do empréstimo
     */
    public Emprestimo atualizar(Emprestimo objeto);

    /**
     * Método que remove um empréstimo específico
     * @param objeto objeto do empréstimo
     */
    public void deletar(Emprestimo objeto);

    /**
     * Método que remove todos os empréstimos
     */
    public void deletarTodos();
}
