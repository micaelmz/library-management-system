package test.model;

import main.model.Bibliotecario;
import main.model.Emprestimo;
import main.model.Leitor;
import main.model.Livro;
import main.GlobalData;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmprestimoTest {

    Emprestimo emprestimo1;
    Emprestimo emprestimo2;
    Emprestimo emprestimo3;

    @Before
    public void gerarEmprestimos() {
        Leitor exemploLeitor = new Leitor(
                1,
                "johndoe",
                "123456",
                "John Doe",
                "St. Lorem Ipsum, 123",
                "(99) 99999-9999"
        );

        Livro exemploLivro = new Livro(
                1,
                "Lorem Ipsum",
                "John Doe",
                "12B34",
                1970,
                "Dolor",
                1,
                1
        );

        emprestimo1 = new Emprestimo(
                exemploLeitor,
                exemploLivro,
                1,
                1
        );

        emprestimo2 = new Emprestimo(
                exemploLeitor,
                exemploLivro,
                0,
                1
        );

        emprestimo3 = new Emprestimo(
                exemploLeitor,
                exemploLivro,
                -1,
                1
        );
    }

    @Test
    public void testaDataEntrega() {
        assertEquals(LocalDate.now().plusDays(1), emprestimo1.getDataEntrega());
        assertEquals(LocalDate.now(), emprestimo2.getDataEntrega());
        assertEquals(LocalDate.now().minusDays(1), emprestimo3.getDataEntrega());
    }

    @Test
    public void testaAtraso() {
        assertFalse(emprestimo1.isAtrasado());
        assertFalse(emprestimo2.isAtrasado());
        assertTrue(emprestimo3.isAtrasado());
    }

    @Test
    public void testaRenovacao() {
        assertTrue(emprestimo1.isRenovavel());
        emprestimo2.setRenovacoes(0);
        assertFalse(emprestimo2.isRenovavel());
        assertFalse(emprestimo3.isRenovavel());
    }

    @Test
    public void testaCalculaMulta() {
        // data de entrega era ontem
        emprestimo1.setDataEntrega(LocalDate.now().minusDays(1));
        int multa = emprestimo1.calcularMulta();
        assertEquals(2, multa);

        emprestimo1.setDataEntrega(LocalDate.now().minusDays(2));
        multa = emprestimo1.calcularMulta();
        assertEquals(4, multa);
    }

    @Test
    public void testarRenovar() {
        emprestimo1.setDataEntrega(LocalDate.now());
        emprestimo1.setDiasEmprestados(3);
        emprestimo1.setRenovacoes(1);
        emprestimo1.renovar();

        int renovacoesDisponiveis = emprestimo1.getRenovacoes();
        LocalDate novaDataEntrega = emprestimo1.getDataEntrega();

        assertEquals(0, renovacoesDisponiveis);
        assertEquals(LocalDate.now().plusDays(3), novaDataEntrega);
    }

    @Test
    public void testarDevolucao(){
        // usando emprestimo3, que tem 1 dia de atraso
        Livro livro = emprestimo3.getLivro();
        livro.setQuantidade(0);
        Boolean devolvido = emprestimo3.devolver();
        Leitor leitor = emprestimo3.getLeitor();

        assertTrue(devolvido);
        assertTrue(leitor.isBanido());
        assertEquals(LocalDate.now().plusDays(2), leitor.getBanidoAte());
        assertTrue(livro.isDisponivel());
    }
}
