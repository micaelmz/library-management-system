package app.dao;

import app.model.Admin;
import app.dao.AdminDAOList;

import java.io.IOException;

public class ADD_SAMPLE_DATA {
    // esse codigo nao faz nada, nao faz parte do projeto, apenas serve para adicionar dados de exemplo

    static AdminDAOList adminDAOList = new AdminDAOList();
    public static void main(String[] args) throws IOException {
        // criando um ADM inicial
        adminDAOList.create(new Admin("admin","admin","Admin"));
        adminDAOList.saveDatFile();
    }
}
