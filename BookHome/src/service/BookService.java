package service;

import model.Book;
import model.EBook;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books=new ArrayList<>();
    public void addBook(Book book){
        books.add(book);
    }
    public void addEBook(EBook ebook) {
        books.add(ebook);
    }
    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }
    public void removeEBook(String ISBN) {
        books.removeIf(book->book instanceof EBook && book.getISBN().equals(ISBN));
    }
    public Book searchBook(String ISBN) {
        return books.stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }
    public EBook searchEBook(String ISBN) {
        return (EBook) books.stream()
                .filter(book->book instanceof EBook && book.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }
    public List<Book> getBooks() {
        return books;
    }

    public List<EBook> getEBooks() {
        List<EBook> eBooks=new ArrayList<>();
        for(Book book:books){
            if(book instanceof EBook){
                eBooks.add((EBook) book);
            }
        }
        return eBooks;
    }

}
