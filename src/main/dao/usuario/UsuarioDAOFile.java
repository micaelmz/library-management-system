package main.dao.usuario;

import main.model.Usuario;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para usuários</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see Usuario
 * @see UsuarioDAO
 */
public class UsuarioDAOFile implements UsuarioDAO{
    private List<Usuario> listaUsuarios;
    private Integer ultimoID = 0;

    private String destinoArquivo = "C:\\Users\\Victor\\downloads\\usuarios.dat";

    public UsuarioDAOFile() {
        this.listaUsuarios = new LinkedList<Usuario>();
    }

    /**
     * Método que cria um novo usuário
     * @param objeto objeto do usuário
     * @return objeto do usuário
     */
    @Override
    public Usuario criar(Usuario objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaUsuarios.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
            listaUsuarios.add(objeto);
        }
        return objeto;
    }

    @Override
    public void carregarArquivo() throws IOException, ClassNotFoundException {
        FileInputStream arquivoEntrar = new FileInputStream(destinoArquivo);
        ObjectInputStream ler = new ObjectInputStream(arquivoEntrar);
        listaUsuarios = (LinkedList<Usuario>) ler.readObject();
    }

    @Override
    public void salvarArquivo() throws IOException{
        FileOutputStream arquivoSair = new FileOutputStream(destinoArquivo);
        ObjectOutputStream salvar = new ObjectOutputStream(arquivoSair);
        salvar.writeObject(listaUsuarios);
    }

    /**
     * Método que retorna todos os usuários
     * @return lista de usuários
     */
    @Override
    public List<Usuario> lerTodos(){
        return listaUsuarios;
    }

    /**
     * Método que retorna um usuário específico
     * @param id objeto do usuário
     * @return retorna um usuário específico
     */
    @Override
    public Usuario encontrarPorID(Integer id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)){
                return usuario;
            }
        }
        return null;
    }

    /**
     * Método que atualiza os atributos de um usuário específico
     * @param objeto objeto do usuário
     * @return objeto do usuário
     */
    @Override
    public Usuario atualizar(Usuario objeto) {
        // Vai verificar se o objeto já existe na lista.
        if (listaUsuarios.contains(objeto)){
            listaUsuarios.set(listaUsuarios.indexOf(objeto), objeto);
        }
        return objeto;
    }

    /**
     * Método que remove um usuário específico
     * @param objeto objeto do usuário
     */
    @Override
    public void deletar(Usuario objeto) {
        listaUsuarios.remove(objeto);
    }

    /**
     * Método que remove todos os usuários
     */
    @Override
    public void deletarTodos() {
        listaUsuarios.clear();
    }
}
