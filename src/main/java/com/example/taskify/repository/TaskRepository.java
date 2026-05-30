package com.example.taskify.repository;

import com.example.taskify.model.Task;
import com.example.taskify.model.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    List<Task> findAll();

    Optional<Task> findById(String id);

    void deleteById(String id);

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByTitle(String title);
}
