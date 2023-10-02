package main.model;

public class Livro {
    private final Integer id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anoPublicacao;
    private String categoria;
    private Integer quantidade;
    private Integer limiteRenovacoes;

    public Livro(Integer id, String titulo, String autor, String isbn,
                 Integer anoPublicacao, String categoria, int quantidade, Integer limiteRenovacoes) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.limiteRenovacoes = limiteRenovacoes;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Integer getLimiteRenovacoes() {
        return limiteRenovacoes;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setLimiteRenovacoes(Integer limiteRenovacoes) {
        this.limiteRenovacoes = limiteRenovacoes;
    }

    public boolean isDisponivel() {
        return quantidade > 0;
    }

    public void incrementar() {
        this.quantidade++;
    }

    public void decrementar() {
        this.quantidade--;
    }


}
