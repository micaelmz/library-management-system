package thejoseviictor.biblioteca.dao.reserva;

import thejoseviictor.biblioteca.model.Reserva;

import java.util.LinkedList;
import java.util.List;

public class ReservaDAOList implements ReservaDAO{
    private List<Reserva> listaReservas;

    public ReservaDAOList() {
        this.listaReservas = new LinkedList<Reserva>();
    }

    @Override
    public Reserva criar(Reserva objeto) {
        if (!listaReservas.contains(objeto)){
            listaReservas.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Reserva> lerTodos() {
        return listaReservas;
    }

    @Override
    public Reserva encontrarReserva(Reserva objeto) {
        for (Reserva percorrer : listaReservas){
            if (percorrer.getLivro().getId().equals(objeto.getLivro().getId())){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Reserva atualizar(Reserva objeto) {
        int indice = listaReservas.indexOf(objeto);
        if (indice != -1){
            listaReservas.set(indice, objeto);
            return objeto;
        }
        return null;
    }

    @Override
    public void deletar(Reserva objeto) {
        listaReservas.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaReservas.clear();
    }
}
