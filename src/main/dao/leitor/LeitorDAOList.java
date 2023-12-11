package main.dao.leitor;

import main.dao.PastaArquivos;
import main.model.Leitor;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para leitores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
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
    private String destinoArquivo = System.getProperty("user.dir") + "\\files\\Leitores.dat";

    public LeitorDAOList() {
        this.listaLeitores = new LinkedList<Leitor>();
    }

    /**
     * Método que carrega os Leitores do arquivo binário "Leitores.dat" para a lista "listaLeitores".
     */
    @Override
    public void carregarArquivo() throws IOException, ClassNotFoundException {
        FileInputStream arquivoEntrar = new FileInputStream(destinoArquivo);
        ObjectInputStream ler = new ObjectInputStream(arquivoEntrar);
        listaLeitores = (LinkedList<Leitor>) ler.readObject();
    }

    /**
     * Método que salva os Leitores da lista "listaLeitores" para o arquivo binário "Leitores.dat".
     */
    @Override
    public void salvarArquivo() throws IOException{
        PastaArquivos existePastaArquivos = new PastaArquivos();
        existePastaArquivos.verificarPastaArquivos();
        FileOutputStream arquivoSair = new FileOutputStream(destinoArquivo);
        ObjectOutputStream salvar = new ObjectOutputStream(arquivoSair);
        salvar.writeObject(listaLeitores);
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
     * @param id objeto do leitor
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
