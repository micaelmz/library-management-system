package main.dao.admin;

import main.dao.PastaArquivos;
import main.model.Admin;
import main.model.Bibliotecario;
import main.model.Usuario;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta classe implementa os métodos CRUD para administradores</b>
 * Os métodos de armazenamento atuais são os arquivos binários ".dat"
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 * @see main.model.Admin
 * @see main.dao.admin.AdminDAO
 */
public class AdminDAOList implements AdminDAO {
    private List<Admin> listaAdmins;
    private Integer ultimoID = 0;
    private String destinoArquivo = System.getProperty("user.dir") + "\\files\\Admins.dat";

    public AdminDAOList() {
        this.listaAdmins = new LinkedList<Admin>();
    }

    /**
     * Método que carrega os Admins do arquivo binário "Admins.dat" para a lista "listaAdmins".
     */
    @Override
    public void carregarArquivo() throws IOException, ClassNotFoundException {
        FileInputStream arquivoEntrar = new FileInputStream(destinoArquivo);
        ObjectInputStream ler = new ObjectInputStream(arquivoEntrar);
        listaAdmins = (LinkedList<Admin>) ler.readObject();
    }

    /**
     * Método que salva os Admins da lista "listaAdmins" para o arquivo binário "Admins.dat".
     */
    @Override
    public void salvarArquivo() throws IOException{
        PastaArquivos existePastaArquivos = new PastaArquivos();
        existePastaArquivos.verificarPastaArquivos();
        FileOutputStream arquivoSair = new FileOutputStream(destinoArquivo);
        ObjectOutputStream salvar = new ObjectOutputStream(arquivoSair);
        salvar.writeObject(listaAdmins);
    }

    /**
     * Método que cria um novo administrador
     *
     * @param objeto objeto do administrador
     * @return objeto do administrador
     */
    @Override
    public Admin criar(Admin objeto) {
        // Vai verificar se o objeto já existe na lista.
        if (!listaAdmins.contains(objeto)) {
            ultimoID++;
            objeto.setId(ultimoID);
            listaAdmins.add(objeto);
        }
        return objeto;
    }

    /**
     * Método que retorna todos os administradores
     *
     * @return lista de administradores
     */
    @Override
    public List<Admin> lerTodos() {
        return listaAdmins;
    }

    /**
     * Método que retorna um administrador específico
     *
     * @param id objeto do administrador
     * @return retorna um administrador específico
     */
    @Override
    public Admin encontrarPorID(Integer id) {
        for (Admin admin : listaAdmins) {
            if (admin.getId().equals(id)) {
                return admin;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um administrador específico
     *
     * @param objeto objeto do administrador
     * @return objeto do administrador
     */
    @Override
    public Admin atualizar(Admin objeto) {
        if (listaAdmins.contains(objeto)) {
            listaAdmins.set(listaAdmins.indexOf(objeto), objeto);
        }
        return objeto;
    }

    /**
     * Método que remove um administrador específico
     *
     * @param objeto objeto do administrador
     */
    @Override
    public void deletar(Admin objeto) {
        listaAdmins.remove(objeto);
    }

    /**
     * Método que remove todos os administradores
     */
    @Override
    public void deletarTodos() {
        listaAdmins.clear();
    }
}
