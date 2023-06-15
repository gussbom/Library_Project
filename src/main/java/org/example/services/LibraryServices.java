package org.example.services;

import org.example.entities.Library;

public interface LibraryServices {
    void openLibrary(String filePath, Library library);
    //static String borrowOutBooks(Library library);
}
