package com.tdd.workshop.taskapp.task.web;

import com.tdd.workshop.taskapp.task.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        // !TODO Logic to be added...
        return "tasks";
    }

    @PostMapping("/tasks")
    public String addTask(@RequestParam("title") String title) {
        // !TODO Logic to be added...
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/toggle")
    public String toggle(@PathVariable Long id) {
        // !TODO Logic to be added...
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/delete")
    public String delete(@PathVariable Long id) {
        // !TODO Logic to be added...
        return "redirect:/";
    }
}
