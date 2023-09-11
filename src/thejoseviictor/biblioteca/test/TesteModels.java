package thejoseviictor.biblioteca.test;

import thejoseviictor.biblioteca.model.*;

/**
 * <b>Esta classe implementa um teste dos Getters e Setters dos Models.</b>
 * Portanto, ela poderá ser excluída do repositório no futuro!
 *
 * @author José Victor
 */

public class TesteModels {
    public static void main(String[] args){
        // Classe "Usuario":
        Usuario usuario = new Usuario("victor", "12345");
        System.out.println("Usuário: " + usuario.getUsuario());
        System.out.println("Senha: " + usuario.getSenha());
        usuario.setUsuario("josevictor");
        usuario.setSenha("01234");
        System.out.println("Usuário: " + usuario.getUsuario());
        System.out.println("Senha: " + usuario.getSenha() + "\n");

        // Classe "Leitor":
        Leitor leitor = new Leitor(usuario.getUsuario(), usuario.getSenha(), 1, "Victor",
                "Endereco","12345678", false, 0);
        System.out.println("ID: " + leitor.getId());
        System.out.println("Nome: " + leitor.getNome());
        System.out.println("Endereço: " + leitor.getEndereco());
        System.out.println("Telefone: " + leitor.getTelefone());
        System.out.println("Multas: " + leitor.getMulta());
        System.out.println("Banido: " + leitor.isBanido());
        leitor.setMulta(10);
        leitor.setBanido(true);
        System.out.println("Banido: " + leitor.isBanido());
        System.out.println("Multas: " + leitor.getMulta() + "\n");

        // Classe "Operadores":
        Operadores operador = new Operadores(usuario.getUsuario(), usuario.getSenha(), 2, "Admin");
        System.out.println("ID: " + operador.getId());
        System.out.println("Cargo: " + operador.getCargo());
        operador.setId(5);
        operador.setCargo("Bibliotecario");
        System.out.println("ID: " + operador.getId());
        System.out.println("Cargo: " + operador.getCargo() + "\n");

        // Classe "Admin":
        Admin admin = new Admin(usuario.getUsuario(), usuario.getSenha(), operador.getId(), operador.getCargo(), "Ben");
        System.out.println("Nome: " + admin.getNome());
        admin.setNome("Peter");
        System.out.println("Nome: " + admin.getNome());
        admin.setCargo("Admin");
        System.out.println("Cargo: " + admin.getCargo() + "\n");

        // Classe "Bibliotecario":
        Bibliotecario bibliotecario = new Bibliotecario(usuario.getUsuario(), usuario.getSenha(), operador.getId(), operador.getCargo(), "Spider");
        System.out.println("Nome: " + bibliotecario.getNome());
        bibliotecario.setNome("Ben");
        System.out.println("Nome: " + bibliotecario.getNome());
        bibliotecario.setCargo("Bibliotecario");
        System.out.println("Cargo: " + bibliotecario.getCargo() + "\n");

        // Classe "Acervo":
        Acervo acervo = new Acervo(0);
        System.out.println("Quantidade de Livros no Acervo: " + acervo.getQuantLivros() + "\n");

        // Classe "Livro":
        Livro livro = new Livro(acervo, 1, "Livro de Testes", "José Victor", "12345",
                2023, "Aventura", 1, true, 1);
        acervo.setQuantLivros(1);
        System.out.println("Quantidade de Livros no Acervo: " + acervo.getQuantLivros() + "\n");
        System.out.println("ID: " + livro.getId());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("ISBN: " + livro.getISBN());
        System.out.println("Ano de Publicação: " + livro.getPubli());
        System.out.println("Categoria: " + livro.getCategoria());
        System.out.println("Quantidade: " + livro.getQuantidade());
        System.out.println("Disponível: " + livro.isDisponivel());
        System.out.println("Limite de Renovações: " + livro.getLimitRenov());
        livro.setLimitRenov(10);
        System.out.println("Limite de Renovações: " + livro.getLimitRenov() + "\n");

        // Classe "Reserva":
        Reserva reserva = new Reserva(livro);
        reserva.setReservas(leitor.getId());
        System.out.println("Reservado para (ID): " + reserva.getReservas());
        System.out.println("Título do Livro na Reserva: " + reserva.getLivro().getTitulo() + "\n");

        // Classe "Emprestados":
        Emprestados emprestados = new Emprestados(livro, 1);
        emprestados.setUsers(leitor.getId());
        emprestados.setAtrasados(leitor.getId());
        emprestados.setEmprestados(1);
        System.out.println("Título: " + emprestados.getLivro().getTitulo());
        System.out.println("Quantidade de Emprestados: " + emprestados.getEmprestados());
        System.out.println("Emprestados para (ID): " + emprestados.getUsers());
        System.out.println("Empréstimos Atrasados (ID): " + emprestados.getAtrasados() + "\n");

        // Classe "Emprestimo":
        Emprestimo emprestimo = new Emprestimo(leitor, "01/01/2023", "10/01/2023", 0, 1);
        System.out.println("Nome do Leitor: " + emprestimo.getLeitor().getNome());
        System.out.println("Inicio do Empréstimo: " + emprestimo.getInicio());
        System.out.println("Fim do Empréstimo: " + emprestimo.getFim());
        System.out.println("Renovações: " + emprestimo.getRenovacoes());
        System.out.println("ID do Livro: " + emprestimo.getLivroID());
    }
}
