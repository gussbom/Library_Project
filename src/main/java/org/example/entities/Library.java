package org.example.entities;

import java.util.List;
import java.util.Queue;

public class Library {

    private List<Books> booksInLibrary;
    private Queue<User> queueOfUsers;
    private User librarian;

    public Library() {
    }

    public Library(User librarian) {
        this.librarian = librarian;
    }

    public Library(Queue<User> queueOfUsers) {
        this.queueOfUsers = queueOfUsers;
    }

    public Library(List<Books> booksInLibrary) {
        this.booksInLibrary = booksInLibrary;
    }

    public List<Books> getBooksInLibrary() {
        return booksInLibrary;
    }

    public void setBooksInLibrary(List<Books> booksInLibrary) {
        this.booksInLibrary = booksInLibrary;
    }

    public Queue<User> getQueueOfUsers() {
        return queueOfUsers;
    }

    public void setQueueOfUsers(Queue<User> queueOfUsers) {
        this.queueOfUsers = queueOfUsers;
    }

    public User getLibrarian() {
        return librarian;
    }

    public void setLibrarian(User librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return "Library{" +
                "booksInLibrary=" + booksInLibrary +
                ", queueOfUsers=" + queueOfUsers +
                ", librarian=" + librarian +
                '}';
    }
}
