package com.example.taskify.service;

import com.example.taskify.model.Task;
import com.example.taskify.model.TaskStatus;

import java.util.List;

public interface TaskServiceInterface {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(String id);

    void deleteTask(String id);

    List<Task> searchByTitle(String title);

    List<Task> filterByStatus(TaskStatus status);

    Task updateStatus(String id, TaskStatus status);

}
