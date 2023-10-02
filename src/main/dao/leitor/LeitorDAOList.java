package main.dao.leitor;

import main.model.Leitor;
import main.model.Livro;

import java.util.LinkedList;
import java.util.List;

public class LeitorDAOList implements LeitorDAO{
    private List<Leitor> listaLeitores;
    private Integer ultimoID = 0;


    public LeitorDAOList() {
        this.listaLeitores = new LinkedList<Leitor>();
    }

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

    @Override
    public List<Leitor> lerTodos() {
        return listaLeitores;
    }

    @Override
    public Leitor encontrarPorID(Integer id) {
        for (Leitor leitor : listaLeitores) {
            if (leitor.getId().equals(id)){
                return leitor;
            }
        }
        return null;
    }

    @Override
    public Leitor atualizar(Leitor objeto) {
        if (listaLeitores.contains(objeto)){
            listaLeitores.set(listaLeitores.indexOf(objeto), objeto);
        }
        return objeto;
    }

    @Override
    public void deletar(Leitor objeto) {
        listaLeitores.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaLeitores.clear();
    }
}
