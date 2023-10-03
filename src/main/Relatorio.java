package main;

import main.dao.emprestimo.EmprestimoDAOList;
import main.dao.leitor.LeitorDAOList;
import main.enums.StatusEmprestimo;
import main.model.Emprestimo;
import main.model.Leitor;
import main.model.Livro;

import java.util.*;

/**
 * <b>Esta classe permite gerar relatorios e estatisticas</b>
 *
 * @author Micael Muniz
 */

public class Relatorio {
    EmprestimoDAOList emprestimoDAOList;
    LeitorDAOList leitorDAOList;
    LinkedList<Emprestimo> livrosEmprestados;
    LinkedList<Emprestimo> livrosEmAtraso;
    LinkedList<Emprestimo> livrosReservados;

    public Relatorio(EmprestimoDAOList emprestimoDAOList, LeitorDAOList leitorDAOList) {
        this.emprestimoDAOList = emprestimoDAOList;
        this.leitorDAOList = leitorDAOList;
        this.livrosEmprestados = new LinkedList<>();
        this.livrosEmAtraso = new LinkedList<>();
        this.livrosReservados = new LinkedList<>();
    }

    /**
     * Método que separa os empréstimos em ativos, em atraso e reservados, em forma de listas
     */
    public void gerarListasEmprestimo() {
        for (Emprestimo emprestimo : emprestimoDAOList.lerTodos()) {
            if (emprestimo.getStatus().equals(StatusEmprestimo.ATIVO)) {
                livrosEmprestados.add(emprestimo);
            } else if (emprestimo.getStatus().equals(StatusEmprestimo.RESERVADO)) {
                livrosReservados.add(emprestimo);
            }
            if (emprestimo.isAtrasado()) {
                livrosEmAtraso.add(emprestimo);
            }
        }
    }

    /**
     * Método que retorna a lista de empréstimos de um leitor
     * @param id id do leitor
     * @return lista de empréstimos do leitor
     */
    public LinkedList<Emprestimo> getEmprestimosByLeitor(Integer id) {
        Leitor leitor = leitorDAOList.encontrarPorID(id);
        if (leitor != null) {
            return leitor.getHistoricoEmprestimo();
        }
        return null;
    }

    /**
     * Método que retorna a quantidade de empréstimos de um leitor
     * @param id id do leitor
     * @return quantidade de empréstimos do leitor
     */
    public Integer getQuantidadeEmprestimosByLeitor(Integer id) {
        return getEmprestimosByLeitor(id).size();
    }

    /**
     * Método que retorna os empéstimos ativos (empréstimos que ainda não foram devolvidos)
     * @return lista de empréstimos ativos
     */
    public LinkedList<Emprestimo> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    /**
     * Método que retorna os empréstimos em atraso
     * @return lista de empréstimos em atraso
     */
    public LinkedList<Emprestimo> getLivrosEmAtraso() {
        return livrosEmAtraso;
    }

    /**
     * Método que retorna os empréstimos reservados (empréstimos na fila de espera)
     * @return lista de empréstimos reservados
     */
    public LinkedList<Emprestimo> getLivrosReservados() {
        return livrosReservados;
    }

    /**
     * Método que retorna os livros mais populares (livros com mais empréstimos)
     * o metodo separa os emprestimos em um HashMap com Livro : Quantidade de emprestimos
     * e depois cria uma lista ordenada por quantidade de emprestimos de forma decrescente
     * @return lista de livros mais populares
     */
    public List<Livro> getLivrosMaisPopulares() {
        HashMap<Livro, Integer> livroParaContagem = new HashMap<>();

        // Salva em um HashMap a quantidade de empréstimos de cada livro unico
        for (Emprestimo emprestimo : emprestimoDAOList.lerTodos()) {
            livroParaContagem.put(emprestimo.getLivro(), livroParaContagem.getOrDefault(emprestimo.getLivro(), 0) + 1);
        }

        // Organiza uma lista com livros únicos ordenados por quantidade de empréstimos
        List<Livro> livrosPopulares = new ArrayList<>(livroParaContagem.keySet());
        livrosPopulares.sort(Comparator.comparingInt(livroParaContagem::get).reversed());

        return livrosPopulares;
    }
}
