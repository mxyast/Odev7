package com.mit.odev7.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.mit.odev7.R;
import com.mit.odev7.databinding.FargmentAnasayfaBinding;
import com.mit.odev7.ui.adapter.TodoAdapter;
import com.mit.odev7.ui.viewmodel.AnasayfaViewModel;

public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener{
    private FargmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fargment_anasayfa, container, false);

        binding.setAnasayfaToolbarBaslik("toDo");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarAnasayfa);

        viewModel.toDoListesi.observe(getViewLifecycleOwner(),toDoListesi -> {
            TodoAdapter adapter = new TodoAdapter(requireContext(),toDoListesi,viewModel);
            binding.setToDoAdapter(adapter);
        });

        binding.setAnasayfaFragment(this);

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(AnasayfaFragment.this);
            }
            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return binding.getRoot();
    }

    public void fabTikla(View view){
        Navigation.findNavController(view).navigate(R.id.toDoKayitGecis);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.ara(newText);
        return true;
    }
    @Override
    public void onResume(){
        super.onResume();
        viewModel.toDoYukle();
    }
}
