package com.todolist.todo.Services;

import com.todolist.todo.Models.User;
import com.todolist.todo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        boolean emailExists = userRepository.existsByEmail(user.getEmail());
        if (emailExists == true) {
            System.out.println("User exists");
        } else {
            userRepository.save(user);
        }
        return user;
    }
}
