package model;

import java.util.ArrayList;

import java.util.List;

public class User {
   private String username;
   private String password;
   private List<Book> borrowedbooks = new ArrayList<>();
   private List<Book> returnedbooks = new ArrayList<>();
   private List<EBook> uploadedEBooks=new ArrayList<>();

   public User(String username, String password) {
       this.username = username;
       this.password = password;
   }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
       return password;
    }
    public void setPassword(String password) {
       this.password = password;
    }
    public List<Book> getBorrowedbooks() {
       return borrowedbooks;
    }
    public void borrowBook(Book book) {
       this.borrowedbooks.add(book);
    }
    public List<Book> getReturnedbooks() {
       return returnedbooks;
    }
    public void returnBook(Book book) {
       this.returnedbooks.remove(book);
    }


    public void uploadEBook(EBook ebook) {
       uploadedEBooks.add(ebook);
    }
    public List<EBook> getUploadedEBooks() {
       return uploadedEBooks;

    }
}


