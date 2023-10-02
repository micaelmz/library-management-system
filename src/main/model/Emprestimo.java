package main.model;

import main.enums.StatusEmprestimo;

import java.time.LocalDate;

public class Emprestimo {
    private final Leitor leitor;
    private final Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataEntrega;
    private Integer diasEmprestados;
    private Integer renovacoes;
    private StatusEmprestimo status;
    private Integer id;

    public Emprestimo(Leitor leitor, Livro livro, Integer diasEmprestados, Integer renovacoes) {
        this.leitor = leitor;
        this.livro = livro;
        this.renovacoes = renovacoes;
        this.diasEmprestados = diasEmprestados;
        this.dataEmprestimo = LocalDate.now();
        this.dataEntrega = dataEmprestimo.plusDays(diasEmprestados);
        this.status = StatusEmprestimo.ATIVO;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public Integer getDiasEmprestados() {
        return diasEmprestados;
    }

    public Integer getRenovacoes() {
        return renovacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRenovacoes(Integer renovacoes) {
        this.renovacoes = renovacoes;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setDiasEmprestados(Integer diasEmprestados) {
        this.diasEmprestados = diasEmprestados;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setAsFinalizado() {
        this.status = StatusEmprestimo.FINALIZADO;
    }

    public void setAsAtivo() {
        this.status = StatusEmprestimo.ATIVO;
    }

    public void setAsReservado() {
        this.status = StatusEmprestimo.RESERVADO;
        this.dataEntrega = null;
    }

    public StatusEmprestimo getStatus() {
        return this.status;
    }

    public boolean isAtrasado() {
        return LocalDate.now().isAfter(dataEntrega);
    }

    public boolean isRenovavel() {
        return renovacoes > 0 && !isAtrasado() && status == StatusEmprestimo.ATIVO && livro.getReservas().isEmpty();
    }

    public int calcularMulta() {
        // Calcula multa: 2 dias de banimento para cada dia de atraso.
        int diasAtrasados = (int) (LocalDate.now().toEpochDay() - dataEntrega.toEpochDay());
        if (diasAtrasados > 0) {
            return diasAtrasados * 2;
        } else {
            return 0;
        }
    }

    public boolean renovar() {
        //todo: verificar se é o usuário atual é um bibliotecário.
        if (isRenovavel()) {
            renovacoes--;
            dataEntrega = dataEntrega.plusDays(diasEmprestados);
            return true;
        }
        return false;
    }

    public boolean devolver() {
        if (isAtrasado()) {
            // Banir leitor por 2 dias para cada dia de atraso.
            leitor.setBanidoAte(LocalDate.now().plusDays(calcularMulta()));
        }

        this.setAsFinalizado();

        if (!livro.getReservas().isEmpty()) {
            Emprestimo proximoEmprestimo = livro.getReservas().getFirst();
            proximoEmprestimo.setAsAtivo();
            proximoEmprestimo.setDataEntrega(LocalDate.now().plusDays(proximoEmprestimo.getDiasEmprestados()));
            livro.adicionarEmprestimo(proximoEmprestimo);
            livro.removerReserva(proximoEmprestimo);
        }

        livro.removerEmprestimo(this);

        return true;
    }
}
