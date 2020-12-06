package com.example.todomaster.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomaster.R;
import com.example.todomaster.databinding.FragmentTaskListBinding;
import com.example.todomaster.viewmodel.TasksVM;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TaskListFragment extends Fragment {

    private TasksVM vm;
    private FragmentTaskListBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentTaskListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vm = new ViewModelProvider(
                Navigation.findNavController(requireActivity(), R.id.nav_host).getBackStackEntry(R.id.nav_graph),
                getDefaultViewModelProviderFactory())
            .get(TasksVM.class);


        RecyclerView rv = binding.taskList;
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        rv.setAdapter(new TaskListAdapter(vm, requireActivity()));

        binding.fab.setOnClickListener(fab -> {
            vm.createEntry();
            Navigation.findNavController(requireActivity(), R.id.nav_host)
                    .navigate(R.id.action_taskListFragment_to_taskEditFragment);
        });


    }
}