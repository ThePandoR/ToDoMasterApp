package com.example.todomaster.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.todomaster.data.model.Task;
import com.example.todomaster.data.persistence.FirestoreTaskRepository;
import com.example.todomaster.data.persistence.TaskListLiveData;
import com.example.todomaster.data.persistence.TaskLiveData;

import java.util.Date;
import java.util.List;

import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class TasksVM extends ViewModel {

    private FirestoreTaskRepository repository;

    private TaskListLiveData tasks;
    private TaskLiveData selected;

    @ViewModelInject
    public TasksVM(FirestoreTaskRepository repo) {
        this.repository = repo;
        tasks = repo.getAllTasks();
    }


    public TaskLiveData getSelected() {
        return selected;
    }

    public void setSelected(String id) {
        this.selected = repository.getTaskById(id);
    }

    public LiveData<List<Task>> getTasks() {
        return tasks;
    }

    public void updateSelected() {
        repository.updateTask(selected.getValue());
    }

    public void createEntry() {
        Task e = new Task();
        e.setDate(new Date());
        selected = repository.addTask(e);
    }

    public void removeEntry() {
        repository.deleteTask(selected.getValue().getId());
    }
}
