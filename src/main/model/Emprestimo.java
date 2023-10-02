package main.model;

import java.time.LocalDate;

public class Emprestimo {
    private final Leitor leitor;
    private final Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataEntrega;
    private Integer diasEmprestados;
    private Integer renovacoes;

    public Emprestimo(Leitor leitor, Livro livro, Integer diasEmprestados, Integer renovacoes) {
        this.leitor = leitor;
        this.livro = livro;
        this.renovacoes = renovacoes;
        this.diasEmprestados = diasEmprestados;
        this.dataEmprestimo = LocalDate.now();
        this.dataEntrega = dataEmprestimo.plusDays(diasEmprestados);
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

    public boolean isAtrasado() {
        return LocalDate.now().isAfter(dataEntrega);
    }

    public boolean isRenovavel() {
        return renovacoes > 0 && !isAtrasado();
    }

    public void renovar() {
        if (isRenovavel()) {
            renovacoes--;
            dataEntrega = dataEntrega.plusDays(diasEmprestados);
        }
    }

    public int calcularMulta() {
        // Calcula multa: 2 dias de banimento para cada dia de atraso.
        int diasAtrasados = (int) (LocalDate.now().toEpochDay() - dataEntrega.toEpochDay());
        if (diasAtrasados > 0) {
            return diasAtrasados * 2;
        }
        else {
            return 0;
        }
    }

    public boolean devolver() {
        if (isAtrasado()) {
            // Banir leitor por 2 dias para cada dia de atraso.
            leitor.setBanidoAte(LocalDate.now().plusDays(calcularMulta()));
        }
        // Deixa livro disponível para empréstimo, caso não esteja.
        if (!livro.isDisponivel()) {livro.setDisponivel(true);}
        setDataEntrega(LocalDate.now());
        return true;
    }
}
