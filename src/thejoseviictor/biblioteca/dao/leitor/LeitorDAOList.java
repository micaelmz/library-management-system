package thejoseviictor.biblioteca.dao.leitor;

import thejoseviictor.biblioteca.model.Leitor;

import java.util.LinkedList;
import java.util.List;

public class LeitorDAOList implements LeitorDAO{
    private List<Leitor> listaLeitores;

    public LeitorDAOList() {
        this.listaLeitores = new LinkedList<Leitor>();
    }

    @Override
    public Leitor criar(Leitor objeto) {
        if (!listaLeitores.contains(objeto)){
            listaLeitores.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Leitor> lerTodos() {
        return listaLeitores;
    }

    @Override
    public Leitor encontrarLeitor(Leitor objeto) {
        for (Leitor percorrer : listaLeitores){
            if (percorrer.getId().equals(objeto.getId())){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Leitor atualizar(Leitor objeto) {
        int indice = listaLeitores.indexOf(objeto);
        if (indice != -1){
            listaLeitores.set(indice, objeto);
            return objeto;
        }
        return null;
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
