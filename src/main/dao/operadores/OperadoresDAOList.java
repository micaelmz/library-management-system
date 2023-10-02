package main.dao.operadores;

import main.model.Operadores;
import main.model.Usuario;

import java.util.LinkedList;
import java.util.List;

/**
 * <b>Esta interface implementa os métodos CRUD para operadores</b>
 * O método de armazenamento atual é LinkedList
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Operadores
 * @see main.dao.operadores.OperadoresDAO
 */
public class OperadoresDAOList implements OperadoresDAO{
    private List<Operadores> listaOperadores;
    private Integer ultimoID = 0;

    public OperadoresDAOList() {
        this.listaOperadores = new LinkedList<Operadores>();
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
     * @param objeto objeto do operador
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
