package com.todo.ToDoApp.Services;

import com.todo.ToDoApp.models.Tasks;
import com.todo.ToDoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTasks(String title) {
        Tasks task = new Tasks();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);

    }

    public void deleteTasks(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        System.out.println("I am in TaskSerices");
        Tasks task = taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Illegal id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
