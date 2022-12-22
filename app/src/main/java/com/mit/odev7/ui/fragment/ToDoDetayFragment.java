package com.mit.odev7.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mit.odev7.R;
import com.mit.odev7.data.entity.ToDo;
import com.mit.odev7.databinding.FragmentTodoDetayBinding;
import com.mit.odev7.ui.viewmodel.TodoDetayViewModel;

public class ToDoDetayFragment extends Fragment {
    private FragmentTodoDetayBinding binding;
    private TodoDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo_detay, container, false);
        binding.setToDoDetayToolbarBaslik("toDo Detay");

        ToDoDetayFragmentArgs bundle = ToDoDetayFragmentArgs.fromBundle(getArguments());
        ToDo gelenToDo = bundle.getToDo();
        binding.setToDoNesnesi(gelenToDo);

        binding.setToDoDetayFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TodoDetayViewModel.class);
    }

    public void guncelle(int id,String name){
        viewModel.guncelle(id,name);
    }
}
