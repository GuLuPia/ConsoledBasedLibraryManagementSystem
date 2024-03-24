package com.bookManagement.service;

import com.bookManagement.service.exception.BookNotFoundException;
import com.bookManagement.service.exception.NoBooksFoundException;

/**
 * Provides operations for managing and querying books within a library system.
 * Allows for listing books based on various criteria such as DOI, name, and author.
 * This service is intended for use in environments where books are digitally
 * cataloged and accessible to users for browsing and information retrieval.
 */
public interface BookService {

    /**
     * Lists the details of a single book identified by its Digital Object Identifier (DOI).
     * The DOI is a unique alphanumeric string assigned to a document (in this case, a book)
     * for permanent identification. This method is useful for quickly retrieving
     * the specific details of a book when the DOI is known.
     *
     * @param doi A string representing the Digital Object Identifier of the book.
     *            Must not be null or empty.
     * @throws IllegalArgumentException if the DOI provided is null or empty.
     * @throws BookNotFoundException if no book matching the provided DOI can be found.
     */
    void listBooksByDOI(String doi);

    /**
     * Lists all books currently registered in the system. This method provides a comprehensive
     * view of the library's catalog, showing available and unavailable books alike. It's useful
     * for users wanting to browse the entire collection without specific search criteria.
     *
     * @throws NoBooksFoundException if the system currently has no books cataloged.
     */
    void listAllBooks();

    /**
     * Lists books based on their name. This method supports partial matches,
     * allowing users to find books even when they're unsure of a book's full title.
     * For example, searching for "Harry" could return books titled "Harry Potter".
     *
     * @param name The name or partial name of the book(s) to list.
     *             Must not be null or empty.
     * @throws IllegalArgumentException if the name provided is null or empty.
     * @throws NoBooksFoundException if no books matching the provided name can be found.
     */
    void listBooksByName(String name);

    /**
     * Lists books written by a specific author. This method is particularly useful
     * for users interested in works by a certain author, regardless of the book's title.
     * It enhances discoverability within the library's collection.
     *
     * @param author The full name of the author whose books to list.
     *               Must not be null or empty.
     * @throws IllegalArgumentException if the author name provided is null or empty.
     * @throws NoBooksFoundException if no books by the provided author can be found.
     */
    void listBooksByAuthor(String author);
}
