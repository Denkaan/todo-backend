package com.todolist.todo.Services;

import com.todolist.todo.Models.Task;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTasks();
}
