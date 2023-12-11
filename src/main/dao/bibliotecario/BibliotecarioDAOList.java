package main.dao.bibliotecario;

import main.dao.PastaArquivos;
import main.model.Admin;
import main.model.Bibliotecario;
import main.model.Emprestimo;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para bibliotecários</b>
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
    private String destinoArquivo = System.getProperty("user.dir") + "\\files\\Bibliotecarios.dat";

    public BibliotecarioDAOList() {
        this.listaBibliotecarios = new LinkedList<Bibliotecario>();
    }

    /**
     * Método que carrega os Bibliotecarios do arquivo binário "Bibliotecarios.dat" para a lista "listaBibliotecarios".
     */
    @Override
    public void carregarArquivo() throws IOException, ClassNotFoundException {
        FileInputStream arquivoEntrar = new FileInputStream(destinoArquivo);
        ObjectInputStream ler = new ObjectInputStream(arquivoEntrar);
        listaBibliotecarios = (LinkedList<Bibliotecario>) ler.readObject();
    }

    /**
     * Método que salva os Bibliotecarios da lista "listaBibliotecarios" para o arquivo binário "Bibliotecarios.dat".
     */
    @Override
    public void salvarArquivo() throws IOException{
        PastaArquivos existePastaArquivos = new PastaArquivos();
        existePastaArquivos.verificarPastaArquivos();
        FileOutputStream arquivoSair = new FileOutputStream(destinoArquivo);
        ObjectOutputStream salvar = new ObjectOutputStream(arquivoSair);
        salvar.writeObject(listaBibliotecarios);
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
