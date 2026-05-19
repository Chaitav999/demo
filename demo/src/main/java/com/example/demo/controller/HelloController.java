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

import com.example.demo.repository.TaskRepository;

@CrossOrigin(origins= "*")
@RestController
public class HelloController {

    private TaskRepository repository;
    
    public HelloController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
     
        return repository.findAll();
    }

    @PostMapping("/tasks")
    public List<Task> recieveData(@RequestBody Task task) {
        //TODO: process POST request

        repository.save(task);
        
        return repository.findAll();
    }
    
    @DeleteMapping("/tasks/{idx}")
    public List<Task> deleteTask(@PathVariable long idx){
        
        repository.deleteById(idx);

        return repository.findAll();
    }

    @PutMapping("/tasks/{id}")
    public List<Task> putMethodName(@PathVariable long id) {
        
        Task task = repository.findById(id).get();

        task.setCompleted(true);

        repository.save(task);
        
        return repository.findAll();
    }
    
}
