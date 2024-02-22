package app.dao;

import app.model.Admin;
import app.dao.AdminDAOList;
import app.model.Book;
import app.model.Librarian;
import app.model.Reader;

import java.io.IOException;

public class ADD_SAMPLE_DATA {
    // esse codigo nao faz nada, nao faz parte do projeto, apenas serve para adicionar dados de exemplo

    static AdminDAOList admins;
    static LibrarianDAOList librarians;
    static ReaderDAOList readers;
    static BookDAOList books;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        admins = new AdminDAOList();
        librarians = new LibrarianDAOList();
        readers = new ReaderDAOList();
        books = new BookDAOList();

        // Admins
        Admin admin1 = new Admin("admin", "admin", "Admin");
        Admin admin2 = new Admin("admin2", "admin2", "Admin2");
        admins.create(admin1);
        admins.create(admin2);
        admins.saveDatFile();

        // Librarians
        Librarian librarian1 = new Librarian("librarian", "librarian", "Librarian");
        Librarian librarian2 = new Librarian("librarian2", "librarian2", "Librarian2");
        librarians.create(librarian1);
        librarians.create(librarian2);
        librarians.saveDatFile();

        // Readers
        Reader reader1 = new Reader("reader", "reader", "Reader", "Rua 1", "123456789");
        Reader reader2 = new Reader("reader2", "reader2", "Reader2", "Rua 2", "987654321");
        readers.create(reader1);
        readers.create(reader2);
        readers.saveDatFile();

        // Books
        Integer renovationDays = 7;
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, "Fiction", 2, renovationDays);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960, "Classic", 3, renovationDays);
        Book book3 = new Book("1984", "George Orwell", "9780451524935", 1949, "Dystopian", 1, renovationDays);
        Book book4 = new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769480", 1951, "Coming-of-age", 4, renovationDays);
        Book book5 = new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227", 1937, "Fantasy", 5, renovationDays);
        Book book6 = new Book("Pride and Prejudice", "Jane Austen", "9780141439518", 1813, "Romance", 2, renovationDays);
        Book book7 = new Book("The Da Vinci Code", "Dan Brown", "9780307474278", 2003, "Mystery", 3, renovationDays);

        books.create(book1);
        books.create(book2);
        books.create(book3);
        books.create(book4);
        books.create(book5);
        books.create(book6);
        books.create(book7);
        books.saveDatFile();
    }
}
