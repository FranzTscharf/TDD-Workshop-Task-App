package com.tdd.workshop.taskapp.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean done;

    protected Task() {
        // for JPA
    }

    public Task(String title) {
        // !TODO Logic to be added...
    }

    public Long getId() {
        // !TODO Logic to be added...
    }

    public void setId(Long id) {
        // !TODO Logic to be added...
    }

    public String getTitle() {
        // !TODO Logic to be added...
    }

    public void setTitle(String title) {
        // !TODO Logic to be added...
    }

    public boolean isDone() {
        // !TODO Logic to be added...
    }

    public void setDone(boolean done) {
        // !TODO Logic to be added...
    }
}
