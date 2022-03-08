package com.todolist.todo.Repositories;

import com.todolist.todo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);

    User findTopByEmail(String email);

    User findTopByPassword(String password);
}
