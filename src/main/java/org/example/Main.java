package org.example;

import org.example.entities.Library;
import org.example.entities.User;
import org.example.enums.Role;
import org.example.services.implementation.LibraryServicesImplementation;
import org.example.services.implementation.UserServicesImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.setLibrarian(new User("Benedicta",Role.LIBRARIAN));
        String filePath = "src/main/resources/BookInventory";
        LibraryServicesImplementation libraryServicesImplementation = new LibraryServicesImplementation();
        libraryServicesImplementation.openLibrary(filePath,library);


//        Populate Queue
        Queue<User> userQueue = new LinkedList<>();
        userQueue.add(new User("Joy","New_Physics",Role.JUNIOR_STUDENT));
        userQueue.add(new User("Alex","Economics",Role.SENIOR_STUDENT));
        userQueue.add(new User("John","Ugo_C_Ugo",Role.SENIOR_STUDENT));
        userQueue.add(new User("Pius","Mathematics",Role.TEACHER));
        userQueue.add(new User("Brown","English",Role.TEACHER));
        userQueue.add(new User("Hera","New_Physics",Role.JUNIOR_STUDENT));

        library.setQueueOfUsers(userQueue);

        UserServicesImplementation userServicesImplementation = new UserServicesImplementation();

        int size = library.getQueueOfUsers().size();
        while(size>0){
            System.out.println(userServicesImplementation.borrowBook(library));
//            System.out.println(userServicesImplementation.sortQueueThenBorrowBook(library));
            library.getQueueOfUsers().poll();
            size--;
        }
    }
}