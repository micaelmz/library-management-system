package app.dao.livro;

import app.dao.PastaArquivos;
import app.model.Livro;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para livros</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see app.model.Livro
 * @see app.dao.livro.LivroDAO
 */
public class LivroDAOList implements LivroDAO{
    private List<Livro> listaLivros;
    private Integer ultimoID = 0;
    private String destinoArquivo = System.getProperty("user.dir") + "\\files\\Livros.dat";

    public LivroDAOList() {
        this.listaLivros = new LinkedList<Livro>();
    }

    /**
     * Método que carrega os Livros do arquivo binário "Livros.dat" para a lista "listaLivros".
     */
    @Override
    public void carregarArquivo() throws IOException, ClassNotFoundException {
        FileInputStream arquivoEntrar = new FileInputStream(destinoArquivo);
        ObjectInputStream ler = new ObjectInputStream(arquivoEntrar);
        listaLivros = (LinkedList<Livro>) ler.readObject();
    }

    /**
     * Método que salva os Livros da lista "listaLivros" para o arquivo binário "Livros.dat".
     */
    @Override
    public void salvarArquivo() throws IOException{
        PastaArquivos existePastaArquivos = new PastaArquivos();
        existePastaArquivos.verificarPastaArquivos();
        FileOutputStream arquivoSair = new FileOutputStream(destinoArquivo);
        ObjectOutputStream salvar = new ObjectOutputStream(arquivoSair);
        salvar.writeObject(listaLivros);
    }

    /**
     * Método que cria um novo livro
     * @param objeto objeto do livro
     * @return objeto do livro
     */
    @Override
    public Livro criar(Livro objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaLivros.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
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
     * @param id objeto do livro
     * @return retorna um livro específico
     */
    @Override
    public Livro encontrarPorID(Integer id) {
        for (Livro livro : listaLivros) {
            if (livro.getId().equals(id)){
                return livro;
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
        if (listaLivros.contains(objeto)){
            listaLivros.set(listaLivros.indexOf(objeto), objeto);
        }
        return objeto;
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
