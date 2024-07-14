package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Book;
import model.EBook;
import model.User;
import service.BookService;
import service.UserService;

public class LibraryApp extends Application {
    private static BookService bookService = new BookService();
    private static UserService userService = new UserService();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Management System");

        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 250);

        Button loginButton = new Button("Login");
        layout.getChildren().add(loginButton);
        loginButton.setOnAction(e -> showLoginScreen(primaryStage));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showLoginScreen(Stage primaryStage) {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 300, 250);

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Button loginButton = new Button("Login");

        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(loginButton, 1, 2);

        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();
            User user = userService.LoginUser(username, password);
            if (user != null) {
                showMainMenu(primaryStage);
            } else {
                // Show error message
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password", ButtonType.OK);
                alert.showAndWait();
            }
        });

        primaryStage.setScene(scene);
    }

    private void showMainMenu(Stage primaryStage) {
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 300, 250);

        Button addBookButton = new Button("Add Book");
        addBookButton.setOnAction(e -> showAddBookScreen(primaryStage));
        layout.getChildren().add(addBookButton);

        Button uploadEBookButton = new Button("Upload eBook");
        uploadEBookButton.setOnAction(e -> showUploadEBookScreen(primaryStage));
        layout.getChildren().add(uploadEBookButton);

        primaryStage.setScene(scene);
    }

    private void showAddBookScreen(Stage primaryStage) {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 300, 250);

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();
        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();
        Label isbnLabel = new Label("ISBN:");
        TextField isbnField = new TextField();
        Button saveButton = new Button("Save");

        grid.add(titleLabel, 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(authorLabel, 0, 1);
        grid.add(authorField, 1, 1);
        grid.add(isbnLabel, 0, 2);
        grid.add(isbnField, 1, 2);
        grid.add(saveButton, 1, 3);

        saveButton.setOnAction(event -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String isbn = isbnField.getText();
            Book book = new Book(title, author, isbn);
            bookService.addBook(book);
            showMainMenu(primaryStage);
        });

        primaryStage.setScene(scene);
    }

    private void showUploadEBookScreen(Stage primaryStage) {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 300, 250);

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();
        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();
        Label isbnLabel = new Label("ISBN:");
        TextField isbnField = new TextField();
        Label downloadLinkLabel = new Label("Download Link:");
        TextField downloadLinkField = new TextField();
        Button saveButton = new Button("Save");

        grid.add(titleLabel, 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(authorLabel, 0, 1);
        grid.add(authorField, 1, 1);
        grid.add(isbnLabel, 0, 2);
        grid.add(isbnField, 1, 2);
        grid.add(downloadLinkLabel, 0, 3);
        grid.add(downloadLinkField, 1, 3);
        grid.add(saveButton, 1, 4);

        saveButton.setOnAction(event -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String isbn = isbnField.getText();
            String downloadLink = downloadLinkField.getText();
            EBook eBook = new EBook(title, author, isbn, downloadLink);
            bookService.addEBook(eBook);});
        primaryStage.setScene(scene);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
