package main.dao.admin;

import main.model.Admin;

import java.util.LinkedList;
import java.util.List;

public class AdminDAOList implements AdminDAO{
    private List<Admin> listaAdmins;

    public AdminDAOList() {
        this.listaAdmins = new LinkedList<Admin>();
    }

    @Override
    public Admin criar(Admin objeto) {
        if (!listaAdmins.contains(objeto)){
            listaAdmins.add(objeto);
        }
        return objeto;
    }

    @Override
    public List<Admin> lerTodos() {
        return listaAdmins;
    }

    @Override
    public Admin encontrarAdmin(Admin objeto) {
        for (Admin percorrer : listaAdmins){
            if (percorrer.getNome().equalsIgnoreCase(objeto.getNome())){
                return percorrer;
            }
        }
        return null;
    }

    @Override
    public Admin atualizar(Admin objeto) {
        int indice = listaAdmins.indexOf(objeto);
        if (indice != -1){
            listaAdmins.set(indice, objeto);
            return objeto;
        }
        return null;
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
