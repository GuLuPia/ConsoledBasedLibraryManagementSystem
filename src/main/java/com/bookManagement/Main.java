package com.bookManagement;
import com.bookManagement.entity.Book;
import com.bookManagement.entity.Content;
import com.bookManagement.entity.User;
import com.bookManagement.service.exception.*;
import com.bookManagement.service.impl.BookServiceImpl;
import com.bookManagement.service.impl.BorrowServiceImpl;
import com.bookManagement.service.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    private static boolean isLoggedIn = false;
    private static int userId = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserServiceImpl userService = new UserServiceImpl();
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        BorrowServiceImpl borrowServiceImpl = new BorrowServiceImpl();
        while (true) {
            try {
                System.out.println("\nChoose an option:");
                System.out.println("1: Register");
                System.out.println("2: Login");
                System.out.println("3: List All The Books");
                System.out.println("4: Borrow Book (Login Required)");
                System.out.println("5: Return Book (Login Required)");
                System.out.println("0: Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Username: ");
                        String regUsername = scanner.nextLine();
                        System.out.print("Password: ");
                        String regPassword = scanner.nextLine();
                        userService.register(regUsername, regPassword);
                        break;
                    case 2:
                        System.out.print("Username: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Password: ");
                        String loginPassword = scanner.nextLine();
                        isLoggedIn = userService.login(loginUsername, loginPassword);
                        User user = userService.findUserByUsername(loginUsername);
                        if (isLoggedIn) {
                            userId = user.getId();
                            System.out.println("User-" + userId + ":" + user.getUsername() + " Login successful.");
                        } else {
                            System.out.println("Login failed.");
                        }
                        break;
                    case 3:
                        bookServiceImpl.listAllBooks();
                        break;
                    case 4:
                        if (!isLoggedIn) {
                            System.out.println("Please login first.");
                            break;
                        }
                        borrowBookProcess(scanner, bookServiceImpl, borrowServiceImpl);
                        break;
                    case 5:
                        if (!isLoggedIn) {
                            System.out.println("Please login first.");
                            break;
                        }
                        returnBookProcess(scanner, borrowServiceImpl, bookServiceImpl);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
            } catch (BookNotFoundException | NoBooksFoundException e) {
                System.out.println("Book-related error: " + e.getMessage());
            } catch (UsernameAlreadyExistsException e) {
                System.out.println("User registration error: " + e.getMessage());
            } catch (BookNotAvailableException e) {
                System.out.println("Book Not Available error: " + e.getMessage());
            } catch (AuthenticationFailedException e) {
                System.out.println("Authentication error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
    private static void borrowBookProcess(Scanner scanner, BookServiceImpl bookServiceImpl, BorrowServiceImpl borrowServiceImpl) {
        System.out.println("\nHow would you like to find your book?");
        System.out.println("1: By Book Name");
        System.out.println("2: By Author");
        System.out.println("3: By DOI");
        System.out.println("4: Borrow with Book ID directly");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Enter book name: ");
                bookServiceImpl.listBooksByName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter author's name: ");
                bookServiceImpl.listBooksByAuthor(scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter DOI: ");
                bookServiceImpl.listBooksByDOI(scanner.nextLine());
                break;
            case 4:
                System.out.print("Enter Book ID: ");
                int bookId = Integer.parseInt(scanner.nextLine());
                borrowServiceImpl.borrowBookById(bookId, userId);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void returnBookProcess(Scanner scanner, BorrowServiceImpl borrowServiceImpl, BookServiceImpl bookServiceImpl) {
        System.out.println("\nHow would you like to find the book you're returning?");
        System.out.println("1: By Book Name");
        System.out.println("2: By Author");
        System.out.println("3: By DOI ");
        System.out.println("4: Return with Book ID directly");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Enter book name: ");
                bookServiceImpl.listBooksByName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter author's name: ");
                bookServiceImpl.listBooksByAuthor(scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter DOI: ");
                bookServiceImpl.listBooksByDOI(scanner.nextLine());
                break;
            case 4:
                int bookId = Integer.parseInt(scanner.nextLine());
                borrowServiceImpl.returnBookById(bookId);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

}

