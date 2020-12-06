package com.example.todomaster.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.todomaster.R;
import com.example.todomaster.databinding.FragmentTaskEditBinding;
import com.example.todomaster.viewmodel.TasksVM;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TaskEditFragment extends Fragment {

    private TasksVM vm;
    private FragmentTaskEditBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentTaskEditBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vm = new ViewModelProvider(
                Navigation.findNavController(view).getBackStackEntry(R.id.nav_graph),
                getDefaultViewModelProviderFactory())
                .get(TasksVM.class);

        //New Stuff to be added

        binding.setLifecycleOwner(this);
        binding.setViewModel(vm);

        binding.taskEditSave.setOnClickListener(v -> {
            vm.updateSelected();
            Navigation.findNavController(view).popBackStack();
        });
        binding.taskEditRemove.setOnClickListener(v -> {
            vm.removeEntry();
            Navigation.findNavController(view).popBackStack();
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
