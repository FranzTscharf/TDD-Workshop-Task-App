package com.tdd.workshop.taskapp.task.persistence;

import com.tdd.workshop.taskapp.task.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    TaskRepository repository;

    @Test
    void testFindAllByOrderByIdAscReturnsTasksInOrder() {
        Task firstTask = repository.save(new Task("A"));
        Task secondTask = repository.save(new Task("B"));

        List<Task> tasks = repository.findAllByOrderByIdAsc();

        assertThat(tasks).containsExactly(firstTask, secondTask);
    }
}
