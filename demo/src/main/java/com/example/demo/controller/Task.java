package com.example.demo.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {  //blueprint for a task
    public String title;
    public boolean completed;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private long id;

    public Task(){

    }

    public Task(String title, boolean completed){
        this.title = title;
        this.completed = completed;
    }

    public String getTitle(){
        return title;
    }
    public boolean isCompleted(){
        return completed;
    }
    public long getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
    public void setId(long id){
        this.id = id;
    }

}
