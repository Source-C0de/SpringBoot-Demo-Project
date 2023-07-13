package com.crudProject.crudProject.controller;


import com.crudProject.crudProject.exception.resourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import com.crudProject.crudProject.model.User;
import com.crudProject.crudProject.repository.userRepository;
import com.crudProject.crudProject.Service.userService;
import com.crudProject.crudProject.exception.resourceNotFoundException;

import java.util.List;
//@RestController
//@RequestMapping("/api/v1/")
//@CrossOrigin("http://localhost:3000")
@Controller
public class userController {
    @Autowired
    private userService UserService;

    private userController(userService UserService){
        super();
        this.UserService = UserService;
    }
    @GetMapping("/user")
    public String userList(Model model)
    {
        model.addAttribute("users",UserService.getAllUsers());
        return "home";
    }
    @GetMapping("/user/new1")
    public String addPaper(Model model)
    {
        User user = new User();
        model.addAttribute("users",user);
        return "addpaper";
    }
    @PostMapping("/homepage")
    public String saveUser(@ModelAttribute("users") User user)
    {
        UserService.saveUser(user);
        return "redirct:/user";

    }
    @GetMapping("/user/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", UserService.getUserById(id));
        return "edit";
    }

    @PostMapping("/users/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("user") User user,
                                Model model) {

        // get paper from database by id
        User exitUser = UserService.getUserById(id);
        exitUser.setId(id);
        exitUser.setresearchtile(user.getresearchtile());
        exitUser.setresearchpaper(user.getresearchpaper());
        exitUser.setpaperlink(user.getpaperlink());

        // save updated student object
        UserService.updateUser(exitUser);
        return "redirect:/user";
    }

    // handler method to handle delete student request

    @GetMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserService.deleteUserById(id);
        return "redirect:/user";
    }
//    @PostMapping("/user")
//    User newUser(@RequestBody User newUser){
//        return UserRepository.save(newUser);
//    }
//    //get all user
//    @GetMapping("/user")
//      public List<User> getAllUser()
//    {
//        return UserRepository.findAll();
//    }

//    @GetMapping("/user/{id}")
//    User getUserById(@PathVariable Long id)
//    {
//        return UserRepository.findById(id)
//                .orElseThrow(()->new resourceNotFoundException(id));
//    }
//    @PutMapping("/user/{id}")
//    User updateUser(@RequestBody User newUser,@PathVariable Long id)
//    {
//        return UserRepository.findById(id)
//                .map(user -> {
//                    user.setresearchpaper(newUser.getresearchpaper());
//                    user.setresearchtile(newUser.getresearchtile());
//                    user.setpaperlink(newUser.getpaperlink());
//                    return UserRepository.save(user);
//                }).orElseThrow(()->new resourceNotFoundException(id));
//    }
//    @DeleteMapping("/user/{id}")
//    String deleteUser(@PathVariable Long id)
//    {
//        if(!UserRepository.existsById(id))
//        {
//            throw new resourceNotFoundException(id);
//        }
//        UserRepository.deleteById(id);
//        return "Paper Discription Deleted";
//    }


}
