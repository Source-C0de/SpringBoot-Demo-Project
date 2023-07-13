package com.crudProject.crudProject.Service.imp;

import java.util.List;
import org.springframework.stereotype.Service;
import com.crudProject.crudProject.Service.userService;
import com.crudProject.crudProject.repository.userRepository;
import com.crudProject.crudProject.model.User;



@Service
public class userServiceimp implements userService{

    private userRepository UserRepository;
    public userServiceimp(userRepository UserRepository) {
        super();
        this.UserRepository = UserRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return UserRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return UserRepository.findById(id).get();
    }
    @Override
    public User updateUser(User user) {
        return UserRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        UserRepository.deleteById(id);
    }
}
