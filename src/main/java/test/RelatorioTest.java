package test;

import app.dao.livro.LivroDAOList;
import app.model.Livro;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import app.Relatorio;
import app.model.Leitor;
import app.model.Bibliotecario;
import app.dao.leitor.LeitorDAOList;
import app.dao.emprestimo.EmprestimoDAOList;

public class RelatorioTest {

    EmprestimoDAOList emprestimoDAOList = new EmprestimoDAOList();
    LeitorDAOList leitorDAOList = new LeitorDAOList();
    LivroDAOList livroDAOList = new LivroDAOList();
    Bibliotecario bibliotecario = new Bibliotecario("bibliotecario", "123456", "Bibliotecário");
    Relatorio relatorio;

    @Before
    public void setUp() {
        livroDAOList.criar(new Livro("Livro 1", "Autor 1", "123B4", 1970, "Categoria 1", 5, 1));
        livroDAOList.criar(new Livro("Livro 2", "Autor 2", "123B5", 1970, "Categoria 1", 1, 1));
        livroDAOList.criar(new Livro("Livro 3", "Autor 3", "123B6", 1970, "Categoria 1", 2, 1));


        leitorDAOList.criar(new Leitor("joao1", "12345678910", "João", "Rua 1", "123456789"));
        leitorDAOList.criar(new Leitor("joao2", "12345678910", "João", "Rua 1", "123456789"));
        leitorDAOList.criar(new Leitor("joao3", "12345678910", "João", "Rua 1", "123456789"));
        leitorDAOList.criar(new Leitor("joao4", "12345678910", "João", "Rua 1", "123456789"));

        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(1), livroDAOList.encontrarPorID(1), 7, 1));
        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(2), livroDAOList.encontrarPorID(1), 7, 1));
        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(3), livroDAOList.encontrarPorID(1), 7, 1));
        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(4), livroDAOList.encontrarPorID(1), 7, 1));
        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(1), livroDAOList.encontrarPorID(2), 7, 1));
        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(2), livroDAOList.encontrarPorID(2), 7, 1));
        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(1), livroDAOList.encontrarPorID(3), 7, 1));
        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(2), livroDAOList.encontrarPorID(3), 7, 1));
        emprestimoDAOList.criar(bibliotecario.criarEmprestimo(leitorDAOList.encontrarPorID(3), livroDAOList.encontrarPorID(3), 7, 1));

        relatorio = new Relatorio(emprestimoDAOList, leitorDAOList);
        relatorio.gerarListasEmprestimo();

        // Livro 1 emprestado 4 vezes, 1 para cada leitor
        // Livro 2 emprestado 1 vez e reservado 1 vez, para o leitor 1 e 2 respectivamente
        // Livro 3 emprestado 2 vezes e reservado 1 vez, para o leitor 1, 2 e 3 respectivamente
    }

    @After
    public void tearDown() {
        emprestimoDAOList.deletarTodos();
        leitorDAOList.deletarTodos();
        livroDAOList.deletarTodos();
        relatorio = null;
    }

    @Test
    public void testarEmprestados(){
        assertEquals(7, relatorio.getLivrosEmprestados().size());
    }

    @Test
    public void testarReservados(){
        assertEquals(2, relatorio.getLivrosReservados().size());
    }

    @Test
    public void testarAtrasados(){
        assertEquals(0, relatorio.getLivrosEmAtraso().size());
    }

    @Test
    public void testarQuantidadeEmprestimosByLeitor(){
        assertEquals(3, relatorio.getQuantidadeEmprestimosByLeitor(1).intValue());
        assertEquals(3, relatorio.getQuantidadeEmprestimosByLeitor(2).intValue());
        assertEquals(2, relatorio.getQuantidadeEmprestimosByLeitor(3).intValue());
        assertEquals(1, relatorio.getQuantidadeEmprestimosByLeitor(4).intValue());
    }

    @Test
    public void testarLivrosMaisPopulares(){
        assertEquals(3, relatorio.getLivrosMaisPopulares().size());
        assertEquals("Livro 1", relatorio.getLivrosMaisPopulares().get(0).getTitulo());
        assertEquals("Livro 3", relatorio.getLivrosMaisPopulares().get(1).getTitulo());
        assertEquals("Livro 2", relatorio.getLivrosMaisPopulares().get(2).getTitulo());
    }
}