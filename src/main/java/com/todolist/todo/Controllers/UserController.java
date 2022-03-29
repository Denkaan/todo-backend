package com.todolist.todo.Controllers;


import com.todolist.todo.Models.User;
import com.todolist.todo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    private boolean getCurrentUser(@RequestBody User user) {
        return userService.getUser(user);
    }

    @GetMapping("/login/{email}/{password}")
    private boolean findUserByEmail(@PathVariable String email, @PathVariable String password) {
        return userService.getUserByEmail(email, password);
    }

    @PostMapping("/createUser")
    private boolean addUser(@RequestBody User user) {
        boolean user_exits = userService.findUserByEmail(user.getEmail());
        if(user_exits) {
            System.out.println("CANT CREATE USER!");
            return false;
        }
        userService.saveUser(user);
        return true;
    }
}
