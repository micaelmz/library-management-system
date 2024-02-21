package app.dao;

import app.model.Admin;
import app.dao.AdminDAOList;
import app.model.Librarian;

import java.io.IOException;

public class ADD_SAMPLE_DATA {
    // esse codigo nao faz nada, nao faz parte do projeto, apenas serve para adicionar dados de exemplo

    static AdminDAOList admins = new AdminDAOList();
    static LibrarianDAOList librarians = new LibrarianDAOList();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // criando um ADM inicial
        librarians.create(new Librarian("john","oi","Johndoe"));
        librarians.saveDatFile();
    }
}
