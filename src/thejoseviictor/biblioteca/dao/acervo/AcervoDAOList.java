package thejoseviictor.biblioteca.dao.acervo;

import thejoseviictor.biblioteca.model.Acervo;

import java.util.LinkedList;
import java.util.List;

public class AcervoDAOList implements AcervoDAO{
    private List<Acervo> listaAcervos;

    public AcervoDAOList() {
        this.listaAcervos = new LinkedList<Acervo>();
    }

    @Override
    public Acervo criar(Acervo objeto) {
        if (!listaAcervos.contains(objeto)){
            listaAcervos.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Acervo> lerTodos() {
        return listaAcervos;
    }

    @Override
    public Acervo encontrarAcervo(Acervo objeto) {
        for (Acervo percorrer : listaAcervos){
            if (percorrer.equals(objeto)){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Acervo atualizar(Acervo objeto) {
        int indice = listaAcervos.indexOf(objeto);
        if (indice != -1){
            listaAcervos.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    @Override
    public void deletar(Acervo objeto) {
        listaAcervos.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaAcervos.clear();
    }
}
