package main.model;

import java.time.LocalDate;

/**
 * <b>Esta classe implementa os recibos de empréstimo de cada leitor</b>
 * Contendo os seguintes atributos:
 * Leitor associado (Leitor)
 * Livro associado (Livro)
 * Data de início do empréstimo (LocalDate)
 * Data prevista de entrega (LocalDate)
 * Dias emprestados (Integer)
 * Quantidade de renovações (Integer)
 *
 * Apenas os Administradores e Bibliotecários podem criar empréstimos.
 *
 * Exemplo de Uso:
 * Emprestimo emprestimo = new Emprestimo(Leitor, Livro, diasEmprestados, renovacoes);
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 *
 * @see main.model.Cargo
 * @see main.model.Usuario
 * @see main.model.Leitor
 * @see main.model.Livro
 */

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

    /**
     * Método que retorna o leitor associado ao empréstimo
     * @return leitor associado ao empréstimo
     */
    public Leitor getLeitor() {
        return leitor;
    }

    /**
     * Método que retorna o livro associado ao empréstimo
     * @return livro associado ao empréstimo
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * Método que retorna a data de início do empréstimo
     * @return data de início do empréstimo
     */
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Método que retorna a data de entrega do livro
     * @return data de entrega do livro
     */
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    /**
     * Método que retorna a quantidade de dias do empréstimo
     * @return quantidade de dias do empréstimo
     */
    public Integer getDiasEmprestados() {
        return diasEmprestados;
    }

    /**
     * Método que retorna a quantidade de renovações do empréstimo
     * @return quantidade de renovações do empréstimo
     */
    public Integer getRenovacoes() {
        return renovacoes;
    }

    /**
     * Método que modifica a quantidade de renovações do empréstimo
     * @param renovacoes quantidade de renovações do empréstimo
     */
    public void setRenovacoes(Integer renovacoes) {
        this.renovacoes = renovacoes;
    }

    /**
     * Método que modifica a data de entrega do livro
     * @param dataEntrega data de entrega do livro
     */
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * Método que modifica a quantidade de dias do empréstimo
     * @param diasEmprestados quantidade de dias do empréstimo
     */
    public void setDiasEmprestados(Integer diasEmprestados) {
        this.diasEmprestados = diasEmprestados;
    }

    /**
     * Método que modifica a data de início do empréstimo
     * @param dataEmprestimo data de início do empréstimo
     */
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Método que retorna se o empréstimo está atrasado
     * @return empréstimo está atrasado (true ou false)
     */
    public boolean isAtrasado() {
        return LocalDate.now().isAfter(dataEntrega);
    }

    /**
     * Método que retorna se o empréstimo pode ser renovado
     * @return empréstimo pode ser renovado (true ou false)
     */
    public boolean isRenovavel() {
        return renovacoes > 0 && !isAtrasado();
    }

    /**
     * Método que retorna a quantidade de dias de multa por atraso
     * @return quantidade de dias de multa por atraso
     */
    public int calcularMulta() {
        // Calcula multa: 2 dias de banimento para cada dia de atraso.
        int diasAtrasados = (int) (LocalDate.now().toEpochDay() - dataEntrega.toEpochDay());
        if (diasAtrasados > 0) {
            return diasAtrasados * 2;
        } else {
            return 0;
        }
    }

    /**
     * Método que renova um empréstimo
     */
    public void renovar() {
        //todo: verificar se é o usuário atual é um bibliotecário.
        if (isRenovavel()) {
            renovacoes--;
            dataEntrega = dataEntrega.plusDays(diasEmprestados);
        }
    }

    /**
     * Método que encerra um empréstimo e adiciona dias de banimento por atraso
     * @return devolução bem-sucedida
     */
    public boolean devolver() {
        if (isAtrasado()) {
            // Banir leitor por 2 dias para cada dia de atraso.
            leitor.setBanidoAte(LocalDate.now().plusDays(calcularMulta()));
        }
        // Deixa livro disponível para empréstimo, caso não esteja.
        livro.incrementar();
        setDataEntrega(LocalDate.now());
        return true;
    }
}
