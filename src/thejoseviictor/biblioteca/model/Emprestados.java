package thejoseviictor.biblioteca.model;

import java.util.LinkedList;

public class Emprestados {
    private Livro livro;
    private Integer quantidadeEmp;
    private LinkedList<Integer> users; // Esta lista irá armazenar os "IDs" dos usuários que estão com este livro.
    private LinkedList<Integer> usersAtrasados; // Esta lista irá armazenar os "IDs" dos usuários que estão com empréstimos atrasados.

    public Emprestados(Livro livro, Integer quantidadeEmp) {
        this.livro = livro;
        this.quantidadeEmp = quantidadeEmp;
        this.users = new LinkedList<Integer>();
        this.usersAtrasados = new LinkedList<Integer>();
    }

    public Livro getLivro() {
        return livro;
    }

    public Integer getEmprestados() {
        return quantidadeEmp;
    }

    public void setEmprestados(Integer quantidadeEmp) {
        this.quantidadeEmp = quantidadeEmp;
    }

    public LinkedList<Integer> getUsers() {
        return users;
    }

    public void setUsers(Integer leitor) {
        users.add(leitor);
    }

    public LinkedList<Integer> getAtrasados() {
        return usersAtrasados;
    }

    public void setAtrasados(Integer leitor) {
        usersAtrasados.add(leitor);
    }
}
