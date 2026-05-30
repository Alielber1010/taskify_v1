package com.example.taskify.repository;

import com.example.taskify.model.Task;
import com.example.taskify.model.TaskStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("memory")
public class InMemoryTaskRepository implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    @Override
    public Task save(Task task) {
        tasks.add(task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Optional<Task> findById(String id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(String id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public List<Task> findByStatus(TaskStatus status) {
        return tasks.stream()
                .filter(t -> t.getStatus() == status)
                .toList();
    }

    @Override
    public List<Task> findByTitle(String title) {
        return tasks.stream()
                .filter(t -> t.getTitle().toLowerCase()
                        .contains(title.toLowerCase()))
                .toList();
    }
}

