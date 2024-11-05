package com.todo.ToDoApp.repository;

import com.todo.ToDoApp.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
}
