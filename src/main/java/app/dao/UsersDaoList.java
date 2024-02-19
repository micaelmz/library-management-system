package app.dao;

import app.dao.AdminDAOList;
import app.dao.BaseUserDAOList;
import app.dao.LibrarianDAOList;
import app.dao.ModeratorDAOList;
import app.dao.ReaderDAOList;
import app.model.BaseUser;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class UsersDaoList implements CRUD<BaseUser>{
    private static final BaseUserDAOList baseUserDAOList = new BaseUserDAOList();
    private static final AdminDAOList adminDAOList = new AdminDAOList();
    private static final LibrarianDAOList librarianDAOList = new LibrarianDAOList();
    private static final ModeratorDAOList moderatorDAOList = new ModeratorDAOList();
    private static final ReaderDAOList readerDAOList = new ReaderDAOList();

    @Override
    public void loadDatFile() throws IOException, ClassNotFoundException {
        baseUserDAOList.loadDatFile();
        adminDAOList.loadDatFile();
        librarianDAOList.loadDatFile();
        moderatorDAOList.loadDatFile();
        readerDAOList.loadDatFile();
    }

    @Override
    public void saveDatFile() throws IOException {
        baseUserDAOList.saveDatFile();
        adminDAOList.saveDatFile();
        librarianDAOList.saveDatFile();
        moderatorDAOList.saveDatFile();
        readerDAOList.saveDatFile();
    }

    @Override
    public List<BaseUser> getAll() {
        List<BaseUser> everyone = new ArrayList();
        everyone.addAll(baseUserDAOList.getAll());
        everyone.addAll(adminDAOList.getAll());
        everyone.addAll(librarianDAOList.getAll());
        everyone.addAll(moderatorDAOList.getAll());
        everyone.addAll(readerDAOList.getAll());
        return everyone;
    }

    @Override
    public BaseUser findById(Integer id) {
        BaseUser user = baseUserDAOList.findById(id);
        if (user == null) {
            user = adminDAOList.findById(id);
        }
        if (user == null) {
            user = librarianDAOList.findById(id);
        }
        if (user == null) {
            user = moderatorDAOList.findById(id);
        }
        if (user == null) {
            user = readerDAOList.findById(id);
        }
        return user;
    }

    @Override
    public BaseUser create(BaseUser user) {
        return null;
    }

    @Override
    public void update(BaseUser oldUser, BaseUser newUser) {
    }

    @Override
    public void delete(BaseUser user) {
    }

    @Override
    public void deleteAll() {
    }

    public BaseUser findUserByUsername(String username) {
        List<BaseUser> everyone = getAll();
        for (BaseUser user : everyone) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
