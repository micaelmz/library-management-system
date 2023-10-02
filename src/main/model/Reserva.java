package main.model;

import java.util.LinkedList;

/**
 * <b>Esta classe implementa um lista de reservas de um livro</b>
 * Possuindo os seguintes atributos:
 * Livro associado
 * Lista de leitores na reserva, esperando o livro ficar disponível
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Livro
 * @see main.model.Leitor
 */
public class Reserva {
    private final Livro livro;
    private LinkedList<Leitor> reservas; // Esta lista irá armazenar objetos do tipo "Leitor" na fila de reserva.

    public Reserva(Livro livro) {
        this.livro = livro;
        this.reservas = new LinkedList<Leitor>();
    }

    /**
     * Método que retorna o livro associado a reserva
     * @return livro associado a reserva
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * Método que retorna a lista de leitores na reserva
     * @return lista de leitores na reserva
     */
    public LinkedList<Leitor> getReservas() {
        return reservas;
    }

    /**
     * Método que adiciona um leitor a lista de reserva
     * @param leitor objeto do leitor
     */
    public void setReservas(Leitor leitor) {
        reservas.add(leitor);
    }
}
