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
import com.mit.odev7.databinding.FragmentTodoKayitBinding;
import com.mit.odev7.ui.viewmodel.ToDoKayitViewModel;

public class ToDoKayitFragment extends Fragment {
    private FragmentTodoKayitBinding binding;
    private ToDoKayitViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo_kayit, container, false);
        binding.setToDoKayitToolbarBaslik("toDo Ekleme");
        binding.setToDoKayitFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ToDoKayitViewModel.class);
    }

    public void kaydet(String name){
        viewModel.kaydet(name);
    }
}
