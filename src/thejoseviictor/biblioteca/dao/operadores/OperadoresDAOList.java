package thejoseviictor.biblioteca.dao.operadores;

import thejoseviictor.biblioteca.model.Operadores;

import java.util.LinkedList;
import java.util.List;

public class OperadoresDAOList implements OperadoresDAO{
    private List<Operadores> listaOperadores;

    public OperadoresDAOList() {
        this.listaOperadores = new LinkedList<Operadores>();
    }

    @Override
    public Operadores criar(Operadores objeto) {
        if (!listaOperadores.contains(objeto)){
            listaOperadores.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Operadores> lerTodos() {
        return listaOperadores;
    }

    @Override
    public Operadores encontrarOperador(Operadores objeto) {
        for (Operadores percorrer : listaOperadores){
            if (percorrer.getId().equals(objeto.getId())){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Operadores atualizar(Operadores objeto) {
        int indice = listaOperadores.indexOf(objeto);
        if (indice != -1){
            listaOperadores.set(indice, objeto);
            return objeto;
        }
        return null;
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
