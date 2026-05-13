package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins= "*")
@RestController
public class HelloController {
    
    List<Task> tasks = new ArrayList<>();

    @GetMapping("/tasks")
    public List<Task> getTasks() {
     
        return tasks;
    }

    @PostMapping("/tasks")
    public List<Task> recieveData(@RequestBody Task task) {
        //TODO: process POST request

        tasks.add(task);
        
        return tasks;
    }
    
    @DeleteMapping("/tasks/{idx}")
    public List<Task> deleteTask(@PathVariable int idx){
        
        tasks.remove(idx);

        return tasks;
    }
    
}
