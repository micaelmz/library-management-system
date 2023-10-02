package main.model;

import java.util.LinkedList;

public class Livro {
    private Integer id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anoPublicacao;
    private String categoria;
    private Integer quantidade;
    private Integer limiteRenovacoes;
    private LinkedList<Emprestimo> emprestados;
    private LinkedList<Emprestimo> reservas;

    public Livro(String titulo, String autor, String isbn,
                 Integer anoPublicacao, String categoria, int quantidade, Integer limiteRenovacoes) {

        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.limiteRenovacoes = limiteRenovacoes;
        this.emprestados = new LinkedList<Emprestimo>();
        this.reservas = new LinkedList<Emprestimo>();
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

    public LinkedList<Emprestimo> getEmprestados() {
        return emprestados;
    }

    public LinkedList<Emprestimo> getReservas() {
        return reservas;
    }

    public Integer getLimiteRenovacoes() {
        return limiteRenovacoes;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void adicionarEmprestimo(Emprestimo emprestimo){
        this.emprestados.add(emprestimo);
    }

    public void adicionarReserva(Emprestimo emprestimo){
        this.reservas.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo){
        this.emprestados.remove(emprestimo);
    }

    public void removerReserva(Emprestimo emprestimo){
        this.reservas.remove(emprestimo);
    }

    public boolean isDisponivel(){
        return this.quantidade > this.emprestados.size();
    }
}
