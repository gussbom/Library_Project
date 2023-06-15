package org.example.services;

import org.example.entities.Library;

public interface UserServices {
    String borrowBook(Library library);
    String sortQueueThenBorrowBook(Library library);
}
