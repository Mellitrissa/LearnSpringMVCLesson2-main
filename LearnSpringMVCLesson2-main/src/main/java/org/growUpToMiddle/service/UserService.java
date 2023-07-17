package org.growUpToMiddle.service;

import org.growUpToMiddle.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void updateUser(Long userId,User user,String firstName, String lastName,String email);

    User getUserById(Long id);

    void addUser(User user);

    void deleteUser(Long id);
}
