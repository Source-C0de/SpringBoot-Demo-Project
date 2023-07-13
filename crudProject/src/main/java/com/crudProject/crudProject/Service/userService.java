package com.crudProject.crudProject.Service;

import java.util.List;
import com.crudProject.crudProject.model.User;
public interface userService {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

    User updateUser(User user);

    void deleteUserById(Long id);
}
