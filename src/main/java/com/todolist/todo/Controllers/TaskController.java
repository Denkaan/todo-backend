package com.todolist.todo.Controllers;


import com.todolist.todo.Models.Task;
import com.todolist.todo.Services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);

    //POST
    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        logger.info("Course object {}", task.toString());
        return taskService.saveTask(task);
    }

    //GET
    @GetMapping("/getAll")
    public List<Task> getAllTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/taskById/{id}")
    public Task findTaskById(@PathVariable long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/taskByTitle/{title}")
    public List<Task> findTaskByTitle(@PathVariable String title) {
        return taskService.getTaskByTitle(title);
    }

    //PUT
    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task)
    {
        System.out.println("UPDATED");
        return taskService.updateTask(task);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        return taskService.deleteTask(id);
    }
}
