package com.example.taskify.service;


import com.example.taskify.model.Task;
import com.example.taskify.model.TaskStatus;
import com.example.taskify.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService implements TaskServiceInterface {

    private final TaskRepository taskRepository;


    public TaskService(@Qualifier("memory") TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Service Behavior

    // 1. CREATE
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // 2. GET ALL
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // 3. GET BY ID
    @Override
    public Task getTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));
    }

    // 4. DELETE
    @Override
    public void deleteTask(String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));
        taskRepository.deleteById(task.getId());
    }

    // 5. SEARCH BY TITLE
    @Override
    public List<Task> searchByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    // 6. FILTER BY STATUS
    @Override
    public List<Task> filterByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    // UPDATE STATUS (domain behavior)
    @Override
    public Task updateStatus(String id, TaskStatus status) {
        Task task = getTaskById(id);

        if (status == TaskStatus.DONE) {
            task.markDone();
        } else {
            task.markTodo();
        }

        return task;
    }
}


