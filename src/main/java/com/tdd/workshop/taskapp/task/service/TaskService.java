package com.tdd.workshop.taskapp.task.service;

import com.tdd.workshop.taskapp.task.model.Task;
import com.tdd.workshop.taskapp.task.persistence.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        // !TODO Logic to be added...
    }

    public List<Task> findAll() {
        // !TODO Logic to be added...
    }

}
