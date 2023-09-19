package thejoseviictor.biblioteca.dao.reserva;

import thejoseviictor.biblioteca.model.Reserva;

import java.util.List;

public interface ReservaDAO {
    public Reserva criar(Reserva objeto);
    public List<Reserva> lerTodos();
    public Reserva encontrarReserva(Reserva objeto);
    public Reserva atualizar(Reserva objeto);
    public void deletar(Reserva objeto);
    public void deletarTodos();
}
