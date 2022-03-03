package com.todolist.todo.Controllers;


import com.todolist.todo.Models.Task;
import com.todolist.todo.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public String add(@RequestBody Task task) {
        taskService.saveTask(task);
        return "New task is added";
    }

    @GetMapping("/getAll")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
