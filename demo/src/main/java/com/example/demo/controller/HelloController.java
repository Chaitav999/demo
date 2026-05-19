package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.TaskService;

@CrossOrigin(origins= "*")
@RestController
public class HelloController {

    private TaskService taskService;
    
    public HelloController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public List<Task> recieveData(@RequestBody Task task) {
        return taskService.addTask(task);
    }
    
    @DeleteMapping("/tasks/{idx}")
    public List<Task> deleteTask(@PathVariable long idx){
        return taskService.deleteTask(idx);
    }

    @PutMapping("/tasks/{id}")
    public List<Task> putMethodName(@PathVariable long id) {
        return taskService.updateTask(id);
    }
    
}
