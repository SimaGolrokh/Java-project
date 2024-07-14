package model;

public class Review {
    private int rating;
    private String comment;
    private Book book;
    private User user;
    public Review(int rating, String comment, Book book, User user) {
        this.rating = rating;
        this.comment = comment;
        this.book = book;
        this.user = user;

    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
