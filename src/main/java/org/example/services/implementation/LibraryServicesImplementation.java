package org.example.services.implementation;

import org.example.entities.Books;
import org.example.entities.Library;
import org.example.entities.User;
import org.example.services.LibraryServices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LibraryServicesImplementation implements LibraryServices {
    @Override
    public void openLibrary(String filePath, Library library) {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){

            String line ;
            Books newBooks;
            List<Books> bookList = new ArrayList<>();

            while((line= bufferedReader.readLine())!=null){
                String[] tmp = line.split(",");
                newBooks = new Books(tmp[0],Integer.parseInt(tmp[1]));
                bookList.add(newBooks);
            }
           library.setBooksInLibrary(bookList);
    }catch(Exception e){
            e.printStackTrace();
        }
    }
//    @Override
    static public String borrowOutBooks(Library library) {

        User user = library.getQueueOfUsers().peek();

        Predicate<Books> checkAvailabilityOfBook = e ->(e.getName().equals(user.getBookRequest()));
        Predicate<Books> checkAvailableCopiesOfBook = e ->(e.getQuantity()>0);
        Consumer<Library> removeCopyOfBookFromLibrary = e ->
            e.getBooksInLibrary().stream().filter(books -> books.getName().equals(user.getBookRequest()))
                    .findFirst().ifPresent(newBooks -> newBooks.setQuantity(newBooks.getQuantity()-1));


        boolean findBook = library.getBooksInLibrary().stream()
                .anyMatch(checkAvailabilityOfBook.and(checkAvailableCopiesOfBook));


            if(findBook){
                removeCopyOfBookFromLibrary.accept(library);
                return user.getName()+ " borrowed "+ user.getBookRequest();
            }
            return user.getName()+", "+ user.getBookRequest()+ " is out of stock";
    }
}