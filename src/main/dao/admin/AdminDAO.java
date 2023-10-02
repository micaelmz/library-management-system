package main.dao.admin;

import main.model.Admin;

import java.util.List;

public interface AdminDAO {
    public Admin criar(Admin objeto);
    public List<Admin> lerTodos();
    public Admin encontrarPorID(Integer id);
    public Admin atualizar(Admin objeto);
    public void deletar(Admin objeto);
    public void deletarTodos();
}
