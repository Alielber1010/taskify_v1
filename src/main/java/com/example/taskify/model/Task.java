package com.example.taskify.model;

import java.util.UUID;

public class Task {

    private String id;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(String title, String description) {
        validateTitle(title);
        validateDescription(description);


        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
    }

    // invariant rule

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }
    private void validateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
    }

    // Domain Behaviour

    public void updateTitle(String title) {
        validateTitle(title);
        this.title = title;
    }
    public void updateDescription(String description) {
        validateDescription(description);
        this.description = description;
    }
    public void markDone() {
        this.status = TaskStatus.DONE;
    }
    public void markTodo() {
        this.status = TaskStatus.TODO;
    }

    // getters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
