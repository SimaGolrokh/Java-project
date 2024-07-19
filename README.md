
# Concepts Used

## Classes and Objects
- Defined classes like `Book`, `EBook`, `Review`, `User`, `BookService`, `ReviewService`, `UserService`, and `LibraryApp`.
- Created objects of these classes in the `LibraryApp` class.

## Inheritance
- `EBook` extends `Book` to inherit properties and methods from the `Book` class and add its own specific property.

## Encapsulation
- Used private fields with public getter methods in `Book`, `EBook`, `Review`, `User`, and service classes to restrict direct access to the data.

## Polymorphism
- Demonstrated in `LibraryApp` where `List<Book> books = new ArrayList<>();` can hold both `Book` and `EBook` objects.
- Method overriding in `EBook` where the `toString()` method is overridden.


## Collections
- Used `ArrayList` to store collections of `Book`, `Review`, and `User` objects.

## Lambdas and Streams
- Used in `ReviewService` with the `stream()` method to filter reviews for a specific book using lambda expressions.

## Control Structures
- Used in methods like `listReviews` with filtering and collecting using streams and lambdas.
