package thejoseviictor.biblioteca.model;

public class Livro {
    private Acervo acervo;
    private Integer id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anoPublicacao;
    private String categoria;
    private int quantidade;
    private boolean disponivel;
    private Integer limiteRenovacoes;

    public Livro(Acervo acervo, Integer id, String titulo, String autor, String isbn,
                 Integer anoPublicacao, String categoria, int quantidade, boolean disponivel, Integer limiteRenovacoes) {
        this.acervo = acervo;
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.limiteRenovacoes = limiteRenovacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPubli() {
        return anoPublicacao;
    }

    public void setPubli(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getLimitRenov() {
        return limiteRenovacoes;
    }

    public void setLimitRenov(Integer limiteRenovacoes) {
        this.limiteRenovacoes = limiteRenovacoes;
    }
}
