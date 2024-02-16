package app.dao.emprestimo;

import app.dao.PastaArquivos;
import app.model.Emprestimo;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para empréstimos</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see app.model.Bibliotecario
 * @see app.dao.bibliotecario.BibliotecarioDAO
 */
public class EmprestimoDAOList implements EmprestimoDAO{
    private List<Emprestimo> listaEmprestimos;
    private Integer ultimoID = 0;
    private String destinoArquivo = System.getProperty("user.dir") + "\\files\\Emprestimos.dat";

    public EmprestimoDAOList() {
        this.listaEmprestimos = new LinkedList<Emprestimo>();
    }

    /**
     * Método que carrega os Emprestimos do arquivo binário "Emprestimos.dat" para a lista "listaEmprestimos".
     */
    @Override
    public void carregarArquivo() throws IOException, ClassNotFoundException {
        FileInputStream arquivoEntrar = new FileInputStream(destinoArquivo);
        ObjectInputStream ler = new ObjectInputStream(arquivoEntrar);
        listaEmprestimos = (LinkedList<Emprestimo>) ler.readObject();
    }

    /**
     * Método que salva os Emprestimos da lista "listaEmprestimos" para o arquivo binário "Emprestimos.dat".
     */
    @Override
    public void salvarArquivo() throws IOException{
        PastaArquivos existePastaArquivos = new PastaArquivos();
        existePastaArquivos.verificarPastaArquivos();
        FileOutputStream arquivoSair = new FileOutputStream(destinoArquivo);
        ObjectOutputStream salvar = new ObjectOutputStream(arquivoSair);
        salvar.writeObject(listaEmprestimos);
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
     * @param id objeto do empréstimo
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
