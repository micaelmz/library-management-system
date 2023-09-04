package thejoseviictor.biblioteca.model;

public class Leitor extends Usuario{
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;
    private boolean banido;
    private Integer multa;

    public Leitor(String usuario, String senha, Integer id, String nome, String endereco, String telefone, boolean banido, Integer multa) {
        super(usuario, senha);
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.banido = banido;
        this.multa = multa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isBanido() {
        return banido;
    }

    public void setBanido(boolean banido) {
        this.banido = banido;
    }

    public Integer getMulta() {
        return multa;
    }

    public void setMulta(Integer multa) {
        this.multa = multa;
    }

}
