package com.example.demo.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {

    private TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }
    
    public List<Task> getTasks(){

        return repository.findAll();
    }

    public List<Task> addTask(Task task){
        repository.save(task);

        return repository.findAll();
    }

    public List<Task> deleteTask(long id){
        repository.deleteById(id);

        return repository.findAll();
    }

    public List<Task> updateTask(long id){
        Task task = repository.findById(id).get();

        task.setCompleted(true);
        repository.save(task);

        return repository.findAll();
    }
}
