    package com.example.todomaster.data.persistence;


import com.example.todomaster.data.model.Task;

public interface TaskRepository {
    TaskLiveData getTaskById(String id);
    TaskListLiveData getAllTasks();
    TaskLiveData updateTask(Task entry);
    TaskLiveData addTask(Task entry);
    void deleteTask(String id);
}
