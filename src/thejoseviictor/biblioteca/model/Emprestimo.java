package thejoseviictor.biblioteca.model;

import java.util.Date;

public class Emprestimo {
    private Leitor leitor;
    private Date inicio;
    private Date fim;
    private Integer renovacoes;
    private Integer livroID;

    public Emprestimo(Leitor leitor, Date inicio, Date fim, Integer renovacoes, Integer livroID) {
        this.leitor = leitor;
        this.inicio = inicio;
        this.fim = fim;
        this.renovacoes = renovacoes;
        this.livroID = livroID;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Integer getRenovacoes() {
        return renovacoes;
    }

    public void setRenovacoes(Integer renovacoes) {
        this.renovacoes = renovacoes;
    }

    public Integer getLivroID() {
        return livroID;
    }

    public void setLivroID(Integer livroID) {
        this.livroID = livroID;
    }
}
