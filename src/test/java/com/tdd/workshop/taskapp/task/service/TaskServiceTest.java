package com.tdd.workshop.taskapp.task.service;

import com.tdd.workshop.taskapp.task.model.Task;
import com.tdd.workshop.taskapp.task.persistence.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    TaskRepository repository;

    @InjectMocks
    TaskService service;

    @Test
    void testFindAllReturnsTasksFromRepositoryInOrder() {
        Task firstTask = new Task("Task 1");
        firstTask.setId(1L);
        Task secondTask = new Task("Task 2");
        secondTask.setId(2L);

        when(repository.findAllByOrderByIdAsc()).thenReturn(List.of(firstTask, secondTask));

        List<Task> result = service.findAll();

        assertThat(result).containsExactly(firstTask, secondTask);
        verify(repository).findAllByOrderByIdAsc();
    }

    @Test
    void testAddTaskPersistsNonEmptyTitle() {
        Task savedTask = new Task("Title");
        savedTask.setId(42L);
        when(repository.save(any(Task.class))).thenReturn(savedTask);

        Task result = service.addTask("  Title  ");

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(42L);
        assertThat(result.getTitle()).isEqualTo("Title");
        verify(repository).save(any(Task.class));
    }

    @Test
    void testAddTaskReturnsNullForNullOrBlankTitle() {
        Task resultNullTitle = service.addTask(null);
        Task resultEmptyTitle = service.addTask("");
        Task resultBlankTitle = service.addTask("   ");

        assertThat(resultNullTitle).isNull();
        assertThat(resultEmptyTitle).isNull();
        assertThat(resultBlankTitle).isNull();

        verify(repository, never()).save(any());
    }

    @Test
    void testToggleDoneFlipsDoneFlagAndSaves() {
        Task task = new Task("Test");
        task.setId(1L);
        task.setDone(false);

        when(repository.findById(1L)).thenReturn(Optional.of(task));

        service.toggleDone(1L);

        assertThat(task.isDone()).isTrue();
        verify(repository).findById(1L);
        verify(repository).save(task);
    }

    @Test
    void testToggleDoneDoesNothingIfTaskNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        service.toggleDone(99L);

        verify(repository).findById(99L);
        verify(repository, never()).save(any());
    }

    @Test
    void testDeleteByIdDelegatesToRepository() {
        service.deleteById(5L);

        verify(repository).deleteById(5L);
    }
}
