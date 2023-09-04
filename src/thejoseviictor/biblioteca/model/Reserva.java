package thejoseviictor.biblioteca.model;

import java.util.LinkedList;

public class Reserva {
    private Livro livro;
    private LinkedList<Integer> reservas; // Esta lista irá armazenar os "IDs" dos usuários na fila de reserva.

    public Reserva(Livro livro) {
        this.livro = livro;
        this.reservas = new LinkedList<Integer>();
    }

    public Livro getLivro() {
        return livro;
    }

    public LinkedList<Integer> getReservas() {
        return reservas;
    }

    public void setReservas(Integer leitor) {
        reservas.add(leitor);
    }
}
