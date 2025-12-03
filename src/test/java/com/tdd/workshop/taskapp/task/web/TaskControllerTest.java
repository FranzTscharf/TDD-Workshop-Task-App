package com.tdd.workshop.taskapp.task.web;

import com.tdd.workshop.taskapp.task.model.Task;
import com.tdd.workshop.taskapp.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TaskService taskService;

    @Test
    void testIndexAddsTasksToModelAndRendersTasksView() throws Exception {
        when(taskService.findAll()).thenReturn(List.of(new Task("Test Task")));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("tasks"))
                .andExpect(model().attributeExists("tasks"));

        verify(taskService).findAll();
    }

    @Test
    void testAddTaskCallsServiceAndRedirects() throws Exception {
        mockMvc.perform(post("/tasks")
                        .param("title", "New Task"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(taskService).addTask("New Task");
    }

    @Test
    void testToggleCallsServiceAndRedirects() throws Exception {
        mockMvc.perform(post("/tasks/{id}/toggle", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(taskService).toggleDone(1L);
    }

    @Test
    void testDeleteCallsServiceAndRedirects() throws Exception {
        mockMvc.perform(post("/tasks/{id}/delete", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(taskService).deleteById(1L);
    }
}
