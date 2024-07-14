package service;

import model.Book;
import model.EBook;
import model.User;

import java.util.ArrayList;
import java.util.List;
public class UserService {
    private List<User> users  = new ArrayList<>();
    public void registerUser(User user){
        users.add(user);
    }

    public UserService(){
        registerUser(new User("admin", "admin123"));
        registerUser(new User("user", "user123"));
    }
    public User LoginUser(String username,String password){
        return users.stream()
                    .filter(user -> user.getUsername().equals(username)&&user.getPassword().equals(password))
                    .findFirst().orElse(null);
    }
    public void borrowBook(User user,Book book){
        if (book.isAvailable()){
            book.setAvailable(false);
            user.borrowBook(book);
        }
    }
    public void returnBook(User user,Book book){
        if (book.isAvailable()){
            book.setAvailable(true);
            user.returnBook(book);
        }
    }
    public void uploadEBook(User user, EBook ebook, BookService bookService){
        bookService.addEBook(ebook);
        user.uploadEBook(ebook);
    }

    public List<User> getUsers(){
        return users;
    }



}
