package com.example.demo.controller;

public class Task {  //blueprint for a task
    public String title;
    public boolean completed;

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

    public void setTitle(String title){
        this.title = title;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }

}
