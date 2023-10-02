package main.model;

/**
 * <b>Esta classe implementa os livros da Biblioteca e suas cópias</b>
 * Contendo as seguintes informações:
 * ID do livro
 * Título do livro
 * Autor do livro
 * ISBN do livro (International Standard Book Number | Padrão Internacional de Numeração de Livro)
 * Ano de publicação do livro
 * Categoria do livro
 * Quantidade de cópias do livro
 * Limite de renovações do livro
 *
 * Exemplo de Uso:
 * Livro livro = new Livro(id, "titulo", "autor", "isbn", anoPublicacao, "categoria", quantidade, limiteRenovacoes);
 *
 * @author José Victor Oliveira
 * @author Micael Muniz
 */
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

    /**
     * Método que retorna o ID do livro
     * @return ID do livro
     */
    public Integer getId() {
        return id;
    }

    /**
     * Método que retorna o título do livro
     * @return título do livro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método que retorna o autor do livro
     * @return autor do livro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Método que retorna o ISBN do livro
     * @return ISBN do livro
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Método que retorna o ano de publicação do livro
     * @return ano de publicação do livro
     */
    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    /**
     * Método que retorna a categoria do livro
     * @return categoria do livro
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Método que retorna a quantidade de cópias do livro
     * @return quantidade de cópias do livro
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Método que retorna o limite de renovações do livro
     * @return limite de renovações do livro
     */
    public Integer getLimiteRenovacoes() {
        return limiteRenovacoes;
    }

    /**
     * Método que modifica o título do livro
     * @param titulo titulo do livro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método que modifica o autor do livro
     * @param autor autor do livro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Método que modifica o ISBN do livro
     * @param isbn ISBN do livro
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Método que modifica o ano de publicação do livro
     * @param anoPublicacao ano de publicação do livro
     */
    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    /**
     * Método que modifica a categoria do livro
     * @param categoria categoria do livro
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método que modifica a quantidade de cópias do livro
     * @param quantidade quantidade de cópias do livro
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método que modifica o limite de renovações do livro
     * @param limiteRenovacoes limite de renovações do livro
     */
    public void setLimiteRenovacoes(Integer limiteRenovacoes) {
        this.limiteRenovacoes = limiteRenovacoes;
    }

    /**
     * Método que retorna se o livro possui cópias disponíveis
     * @return livro possui cópias disponíveis (true ou false)
     */
    public boolean isDisponivel() {
        return quantidade > 0;
    }

    /**
     * Método que incrementa a quantidade de cópias do livro
     */
    public void incrementar() {
        this.quantidade++;
    }

    /**
     * Método que decrementa a quantidade de cópias do livro
     */
    public void decrementar() {
        this.quantidade--;
    }


}
