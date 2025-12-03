package com.tdd.workshop.taskapp.task.persistence;

import com.tdd.workshop.taskapp.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // !TODO Logic to be added...
}
