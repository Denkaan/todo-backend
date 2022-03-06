package com.todolist.todo.Services;


import com.todolist.todo.Models.Task;
import com.todolist.todo.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    //POST
    public Task saveTask(Task task) {
        System.out.println(task.toString());
        return taskRepository.save(task);
    }

    //GET
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTaskByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    /*
    public List<Task> getTasksForUser(String email) {
        return taskRepository.findAllByEmail(email);
    }

     */

    //PUT
    public Task updateTask(Task task) {
        System.out.println("updates");
        Task existingTask = taskRepository.findById(task.getId()).orElse(null);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDate(task.getDate());
        existingTask.setTime(task.getTime());
        return taskRepository.save(existingTask);
    }

    //DELETE
    public String deleteTask(long id) {
        taskRepository.deleteById(id);
        return id + " id -> task removed/completed";
    }
}
