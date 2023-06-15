package org.example.services.implementation;

import org.example.entities.Books;
import org.example.entities.Library;
import org.example.entities.User;
import org.example.enums.Role;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class LibraryServicesImplementationTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void openLibrary() {
    }

    @Test
    public void borrowOutBooks() {
        Library library = new Library();
        LibraryServicesImplementation libraryServicesImplementation = new LibraryServicesImplementation();

        Books books = new Books("Physics",2);
        User user =  new User("Keji","Physics", Role.SENIOR_STUDENT);

        List<Books> queueBooks = new LinkedList<>();
        Queue<User> userQueue = new LinkedList<>();

        queueBooks.add(books);
        library.setBooksInLibrary(queueBooks);

        userQueue.add(user);
        library.setQueueOfUsers(userQueue);

        String actual = libraryServicesImplementation.borrowOutBooks(library);
        String expected =user.getName()+ " borrowed "+ user.getBookRequest();

        assertEquals(expected,actual);
    }
}