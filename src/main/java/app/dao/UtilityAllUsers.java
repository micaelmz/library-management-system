package app.dao;

import app.model.BaseUser;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class UtilityAllUsers {
    private static final BaseUserDAOList baseUserDAOList = new BaseUserDAOList();
    private static final AdminDAOList adminDAOList = new AdminDAOList();
    private static final LibrarianDAOList librarianDAOList = new LibrarianDAOList();
    private static final ModeratorDAOList moderatorDAOList = new ModeratorDAOList();
    private static final ReaderDAOList readerDAOList = new ReaderDAOList();


    public static List<BaseUser> getAll() throws IOException, ClassNotFoundException{
        List<BaseUser> everyone = new ArrayList<>();
        if (new File(baseUserDAOList.getFilePath()).exists()) {
            baseUserDAOList.loadDatFile();
            everyone.addAll(baseUserDAOList.getAll());
        }
        if (new File(adminDAOList.getFilePath()).exists()) {
            adminDAOList.loadDatFile();
            everyone.addAll(adminDAOList.getAll());
        }
        if (new File(librarianDAOList.getFilePath()).exists()) {
            librarianDAOList.loadDatFile();
            everyone.addAll(librarianDAOList.getAll());
        }
        if (new File(moderatorDAOList.getFilePath()).exists()) {
            moderatorDAOList.loadDatFile();
            everyone.addAll(moderatorDAOList.getAll());
        }
        if (new File(readerDAOList.getFilePath()).exists()) {
            readerDAOList.loadDatFile();
            everyone.addAll(readerDAOList.getAll());
        }

        return everyone;
    }

    public static void saveAll() throws IOException {
        baseUserDAOList.saveDatFile();
        adminDAOList.saveDatFile();
        librarianDAOList.saveDatFile();
        moderatorDAOList.saveDatFile();
        readerDAOList.saveDatFile();
    }

    public static BaseUser findById(Integer id) {
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


    public static BaseUser findUserByUsername(String username) throws IOException, ClassNotFoundException {
        List<BaseUser> everyone = getAll();
        for (BaseUser user : everyone) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static Integer getNewId() throws IOException, ClassNotFoundException {
        Integer id = readIdFromFile();
        writeIdToFile(id + 1);
        return id;
    }

    public static void resetId() throws IOException {
        writeIdToFile(0);
    }

    private static Integer readIdFromFile() throws IOException, ClassNotFoundException {
        String filePath = UtilityDatFilesFolder.getFolderPath() + "\\id_users.dat";
        File idFile = new File(filePath);

        if (!idFile.exists()) {
            if (!idFile.getParentFile().exists()) {
                idFile.getParentFile().mkdirs();
            }
            idFile.createNewFile();
            return 0;
        } else {
            try (FileInputStream file = new FileInputStream(filePath);
                 ObjectInputStream object = new ObjectInputStream(file)) {
                return (Integer) object.readObject();
            }
        }
    }

    private static void writeIdToFile(Integer id) throws IOException {
        String filePath = UtilityDatFilesFolder.getFolderPath() + "\\id_users.dat";
        try (FileOutputStream file = new FileOutputStream(filePath);
             ObjectOutputStream object = new ObjectOutputStream(file)) {
            object.writeObject(id);
        }
    }
}
