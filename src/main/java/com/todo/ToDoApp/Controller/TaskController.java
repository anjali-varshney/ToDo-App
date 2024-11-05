package com.todo.ToDoApp.Controller;

import com.todo.ToDoApp.Services.TaskServices;
import com.todo.ToDoApp.models.Tasks;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class TaskController {
    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Tasks> tasks = taskServices.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTasks(@RequestParam String title){
        taskServices.createTasks(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskServices.deleteTasks(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        System.out.println("I am in Task Controller");
        taskServices.toggleTask(id);
        return"redirect:/";
    }


}
