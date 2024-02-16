package app.dao.operadores;

import app.dao.PastaArquivos;
import app.model.Operadores;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para operadores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see app.model.Operadores
 * @see app.dao.operadores.OperadoresDAO
 */
public class OperadoresDAOList implements OperadoresDAO{
    private List<Operadores> listaOperadores;
    private Integer ultimoID = 0;
    private String destinoArquivo = System.getProperty("user.dir") + "\\files\\Operadores.dat";

    public OperadoresDAOList() {
        this.listaOperadores = new LinkedList<Operadores>();
    }

    /**
     * Método que carrega os Operadores do arquivo binário "Operadores.dat" para a lista "listaOperadores".
     */
    @Override
    public void carregarArquivo() throws IOException, ClassNotFoundException {
        FileInputStream arquivoEntrar = new FileInputStream(destinoArquivo);
        ObjectInputStream ler = new ObjectInputStream(arquivoEntrar);
        listaOperadores = (LinkedList<Operadores>) ler.readObject();
    }

    /**
     * Método que salva os Operadores da lista "listaOperadores" para o arquivo binário "Operadores.dat".
     */
    @Override
    public void salvarArquivo() throws IOException{
        PastaArquivos existePastaArquivos = new PastaArquivos();
        existePastaArquivos.verificarPastaArquivos();
        FileOutputStream arquivoSair = new FileOutputStream(destinoArquivo);
        ObjectOutputStream salvar = new ObjectOutputStream(arquivoSair);
        salvar.writeObject(listaOperadores);
    }

    /**
     * Método que cria um novo operador
     * @param objeto objeto do operador
     * @return objeto do operador
     */
    @Override
    public Operadores criar(Operadores objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaOperadores.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
            listaOperadores.add(objeto);
        }
        return objeto;
    }

    /**
     * Método que retorna todos os operadores
     * @return lista de operadores
     */
    @Override
    public List<Operadores> lerTodos() {
        return listaOperadores;
    }

    /**
     * Método que retorna um operador específico
     * @param id objeto do operador
     * @return retorna um operador específico
     */
    @Override
    public Operadores encontrarPorID(Integer id) {
        for (Operadores operador : listaOperadores) {
            if (operador.getId().equals(id)){
                return operador;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um operador específico
     * @param objeto objeto do operador
     * @return objeto do operador
     */
    @Override
    public Operadores atualizar(Operadores objeto) {
        if (listaOperadores.contains(objeto)){
            listaOperadores.set(listaOperadores.indexOf(objeto), objeto);
        }
        return objeto;
    }

    /**
     * Método que remove um operador específico
     * @param objeto objeto do operador
     */
    @Override
    public void deletar(Operadores objeto) {
        listaOperadores.remove(objeto);
    }

    /**
     * Método que remove todos os operadores
     */
    @Override
    public void deletarTodos() {
        listaOperadores.clear();
    }
}
