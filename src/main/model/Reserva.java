package main.model;

import java.util.LinkedList;

public class Reserva {
    private final Livro livro;
    private LinkedList<Leitor> reservas; // Esta lista irá armazenar objetos do tipo "Leitor" na fila de reserva.

    public Reserva(Livro livro) {
        this.livro = livro;
        this.reservas = new LinkedList<Leitor>();
    }

    public Livro getLivro() {
        return livro;
    }

    public LinkedList<Leitor> getReservas() {
        return reservas;
    }

    public void setReservas(Leitor leitor) {
        reservas.add(leitor);
    }
}
