package main.dao.admin;

import main.model.Admin;
import main.model.Bibliotecario;

import java.util.LinkedList;
import java.util.List;

public class AdminDAOList implements AdminDAO{
    private List<Admin> listaAdmins;
    private Integer ultimoID = 0;

    public AdminDAOList() {
        this.listaAdmins = new LinkedList<Admin>();
    }

    @Override
    public Admin criar(Admin objeto){
        // Vai verificar se o objeto já existe na lista.
        if (!listaAdmins.contains(objeto)){
            ultimoID++;
            objeto.setId(ultimoID);
            listaAdmins.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Admin> lerTodos() {
        return listaAdmins;
    }

    @Override
    public Admin encontrarPorID(Integer id) {
        for (Admin admin : listaAdmins) {
            if (admin.getId().equals(id)){
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin atualizar(Admin objeto) {
        if (listaAdmins.contains(objeto)){
            listaAdmins.set(listaAdmins.indexOf(objeto), objeto);
        }
        return objeto;
    }

    @Override
    public void deletar(Admin objeto) {
        listaAdmins.remove(objeto);
    }

    @Override
    public void deletarTodos() {
        listaAdmins.clear();
    }
}
