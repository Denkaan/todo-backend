package com.todolist.todo.Services;

import com.todolist.todo.Models.User;
import com.todolist.todo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean getUser(User user) {
        boolean status;
        try {
            status = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()) != null ? true : false;
        } catch (NonUniqueResultException nre) {
            return true;
        }
        return status;
    }

    public boolean getUserByEmail(String email, String password) {
        boolean email_present;
        boolean password_present;
        try {
            email_present = userRepository.findTopByEmail(email) != null ? true : false;
            System.out.println("Email present: " + email_present);
            password_present = userRepository.findTopByPassword(password) != null ? true : false;
            System.out.println("Password present: " + password_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return email_present && password_present;
    }

    public boolean findUserByEmail(String email) {
        boolean email_present;
        try {
            email_present = userRepository.findTopByEmail(email) != null ? true : false;
            System.out.println("Username present (U): " + email_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return email_present;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
