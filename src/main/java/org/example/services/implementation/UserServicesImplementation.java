package org.example.services.implementation;

import org.example.entities.Library;
import org.example.entities.User;
import org.example.services.UserServices;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UserServicesImplementation implements UserServices {


    @Override
    public String borrowBook(Library library) {

        //LibraryServicesImplementation libraryServicesImplementation = new LibraryServicesImplementation();

        return LibraryServicesImplementation.borrowOutBooks(library);
    }

    @Override
    public String sortQueueThenBorrowBook(Library library) {
       // LibraryServicesImplementation libraryServicesImplementation = new LibraryServicesImplementation();

        PriorityQueue<User> sortUsers = new PriorityQueue<>(Comparator.comparing(User::getRole));
        sortUsers.addAll(library.getQueueOfUsers());
        library.setQueueOfUsers(sortUsers);

        return LibraryServicesImplementation.borrowOutBooks(library);
    }
}
