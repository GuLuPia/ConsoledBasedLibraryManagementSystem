package com.bookManagement.service;

import com.bookManagement.entity.User;

/**
 * Defines user management operations such as registration, login, and user queries within
 * the library system. This interface is intended to handle user credentials and personalization
 * aspects of the system.
 */
public interface UserService {

    /**
     * Registers a new user with the provided username and password. This method ensures
     * users have unique usernames and secures their password for system access.
     *
     * @param username The chosen username for the new user. Must be unique across the system.
     * @param password The chosen password for the new user.
     * @throws UsernameAlreadyExistsException if the provided username is already in use.
     */
    void register(String username, String password);

    /**
     * Attempts to log a user into the system with the provided credentials. This method
     * verifies user details and grants access if the credentials match those on record.
     *
     * @param username The username of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return true if the login was successful, false otherwise.
     * @throws AuthenticationFailedException if the username or password does not match.
     */
    boolean login(String username, String password);

    /**
     * Retrieves a user entity based on the username. This method allows for user information
     * queries, supporting functionalities like profile viewing or personalization.
     *
     * @param username The username of the user to find.
     * @return A User object if the user is found, null otherwise.
     */
    User findUserByUsername(String username);
}
