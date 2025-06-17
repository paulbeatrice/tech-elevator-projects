package com.techelevator.dao;

import com.techelevator.model.User;
import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int userId);

    User getUserByUsername(String username);

    User createUser(User newUser);

    void deleteUserById(int userId);

    void updateUser(int userId, User updatedUser);
}
