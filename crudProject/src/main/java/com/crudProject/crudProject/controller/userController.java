package com.crudProject.crudProject.controller;


import com.crudProject.crudProject.exception.resourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crudProject.crudProject.model.User;
import com.crudProject.crudProject.repository.userRepository;
import com.crudProject.crudProject.exception.resourceNotFoundException;

import java.util.List;
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:3000")
public class userController {
    @Autowired
    private userRepository UserRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return UserRepository.save(newUser);
    }
    //get all user
    @GetMapping("/user")
    public List<User> getAllUser()
    {
        return UserRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id)
    {
        return UserRepository.findById(id)
                .orElseThrow(()->new resourceNotFoundException(id));
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id)
    {
        return UserRepository.findById(id)
                .map(user -> {
                    user.setresearchpaper(newUser.getresearchpaper());
                    user.setresearchtile(newUser.getresearchtile());
                    user.setpaperlink(newUser.getpaperlink());
                    return UserRepository.save(user);
                }).orElseThrow(()->new resourceNotFoundException(id));
    }
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id)
    {
        if(!UserRepository.existsById(id))
        {
            throw new resourceNotFoundException(id);
        }
        UserRepository.deleteById(id);
        return "Paper Discription Deleted";
    }


}
