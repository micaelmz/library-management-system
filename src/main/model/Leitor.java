package main.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Leitor extends Usuario{
    private String endereco;
    private String telefone;
    private LocalDate banidoAte;
    private LinkedList<Emprestimo> emprestimos = new LinkedList<>();

    public Leitor(Integer id, String usuario, String senha, String nome, String endereco, String telefone) {
        super(
            id,
            usuario,
            senha,
            nome
        );
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getBanidoAte() {
        return banidoAte;
    }

    public boolean isBanido() {
        return banidoAte != null && banidoAte.isAfter(LocalDate.now());
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setBanidoAte(LocalDate banidoAte) {
        this.banidoAte = banidoAte;
    }
}
