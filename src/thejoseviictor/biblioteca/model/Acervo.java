package thejoseviictor.biblioteca.model;

public class Acervo {
    private Integer quantidadeLivros;

    public Acervo(Integer quantidadeLivros) {
        this.quantidadeLivros = quantidadeLivros;
    }

    public Integer getQuantLivros() {
        return quantidadeLivros;
    }

    public void setQuantLivros(Integer quantidadeLivros) {
        this.quantidadeLivros = quantidadeLivros;
    }
}
