package main.dao.operadores;

import main.model.Operadores;
import main.model.Usuario;

import java.util.LinkedList;
import java.util.List;

public class OperadoresDAOList implements OperadoresDAO{
    private List<Operadores> listaOperadores;
    private Integer ultimoID = 0;

    public OperadoresDAOList() {
        this.listaOperadores = new LinkedList<Operadores>();
    }

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

    @Override
    public List<Operadores> lerTodos() {
        return listaOperadores;
    }

    @Override
    public Operadores encontrarPorID(Integer id) {
        for (Operadores operador : listaOperadores) {
            if (operador.getId().equals(id)){
                return operador;
            }
        }
        return null;
    }

    @Override
    public Operadores atualizar(Operadores objeto) {
        if (listaOperadores.contains(objeto)){
            listaOperadores.set(listaOperadores.indexOf(objeto), objeto);
        }
        return objeto;
    }

    @Override
    public void deletar(Operadores objeto) {
        listaOperadores.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaOperadores.clear();
    }
}
