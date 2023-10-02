package main.model;

import main.enums.Cargo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Leitor extends Usuario{
    private String endereco;
    private String telefone;
    private LocalDate banidoAte;
    private LinkedList<Emprestimo> historicoEmprestimo = new LinkedList<>();

    public Leitor(String usuario, String senha, String nome, String endereco, String telefone) {
        super(
            usuario,
            senha,
            nome
        );
        this.endereco = endereco;
        this.telefone = telefone;
        this.setCargo(Cargo.LEITOR);
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

    public LinkedList<Emprestimo> getHistoricoEmprestimo() {
        return historicoEmprestimo;
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

    public void adicionarAoHistoricoEmprestimos(Emprestimo emprestimo) {
        historicoEmprestimo.add(emprestimo);
    }
}
