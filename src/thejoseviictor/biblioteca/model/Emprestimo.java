package thejoseviictor.biblioteca.model;

public class Emprestimo {
    private Leitor leitor;
    private String inicio;
    private String fim;
    private Integer renovacoes;
    private Integer livroID;

    public Emprestimo(Leitor leitor, String inicio, String fim, Integer renovacoes, Integer livroID) {
        this.leitor = leitor;
        this.inicio = inicio;
        this.fim = fim;
        this.renovacoes = renovacoes;
        this.livroID = livroID;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
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
