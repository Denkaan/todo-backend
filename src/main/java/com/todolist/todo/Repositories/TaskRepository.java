package com.todolist.todo.Repositories;

import com.todolist.todo.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitle(String title);

    /*
    List<Task> findAllByEmail(String email);

     */
}
