package com.example.todomaster.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomaster.R;
import com.example.todomaster.data.model.Task;
import com.example.todomaster.databinding.TaskListItemBinding;
import com.example.todomaster.viewmodel.TasksVM;

import java.util.List;


public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {


    private TasksVM tasksVM;
    private LifecycleOwner lifecycleOwner;

    public TaskListAdapter(TasksVM vm, LifecycleOwner lifecycleOwner) {
        this.tasksVM = vm;
        this.lifecycleOwner = lifecycleOwner;

        vm.getTasks().observe(lifecycleOwner, e -> notifyDataSetChanged());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TaskListItemBinding binding = TaskListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.setLifecycleOwner(lifecycleOwner);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setEntry(tasksVM.getTasks().getValue().get(position));
    }

    @Override
    public int getItemCount() {
        List<Task> ls = tasksVM.getTasks().getValue();
        return ls == null ? 0 : ls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TaskListItemBinding binding;
        private Task task;

        public ViewHolder(TaskListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(v -> {
                tasksVM.setSelected(task.getId());
                Navigation.findNavController(v).navigate(R.id.action_taskListFragment_to_taskEditFragment); //Navigation through fragments
            });
        }

        public Task getEntry() {
            return task;
        }

        public void setEntry(Task task) {
            this.task = task;
            binding.setTask(task);
        }
    }
}
