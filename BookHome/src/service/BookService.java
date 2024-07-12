package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books=new ArrayList<>();
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }
    public Book searchBook(String ISBN) {
        return books.stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }
    public List<Book> getBooks() {
        return books;
    }

}
