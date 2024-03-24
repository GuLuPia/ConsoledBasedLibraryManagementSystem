package com.bookManagement.service;

import com.bookManagement.service.exception.BookNotAvailableException;
import com.bookManagement.service.exception.BookNotFoundException;

/**
 * Provides operations related to borrowing and returning books in a library system.
 * This interface supports locating books for borrowing and returning purposes by various identifiers,
 * including book name and book ID, facilitating user interactions with the library's catalog.
 */
public interface BorrowService {

    /**
     * Initiates the borrowing process for a book identified by its name. This method is useful
     * when users wish to borrow a book based on its title. It handles checking the book's availability
     * and updating the catalog to reflect the new status.
     *
     * @param name The name of the book to borrow.
     * @param userId The ID of the user attempting to borrow the book, linking the book to the borrower.
     * @throws BookNotFoundException if no book with the given name is available in the catalog.
     * @throws BookNotAvailableException if the book is currently not available for borrowing.
     */
    void borrowBookByName(String name, int userId);

    /**
     * Facilitates the return of a borrowed book using its name. This method updates the catalog to mark
     * the book as available again, making it accessible for future borrowers.
     *
     * @param name The name of the book being returned.
     * @throws BookNotFoundException if no book with the given name exists in the catalog.
     */
    void returnBookByName(String name);

    /**
     * Enables returning a book directly by its unique identifier. This method is useful for systems
     * where books are managed and tracked using a numeric or alphanumeric ID.
     *
     * @param bookId The ID of the book being returned.
     * @throws BookNotFoundException if no book with the given ID exists in the catalog.
     */
    void returnBookById(int bookId);

    /**
     * Allows a user to borrow a book directly by its unique ID. This method checks the book's
     * availability before proceeding with the borrowing process, similar to borrowing by name.
     *
     * @param bookId The ID of the book to borrow.
     * @param userId The ID of the user borrowing the book.
     * @throws BookNotFoundException if no book with the given ID is found in the catalog.
     * @throws BookNotAvailableException if the book is currently not available for borrowing.
     */
    void borrowBookById(int bookId, int userId);
}
