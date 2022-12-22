package com.mit.odev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.mit.odev7.data.repo.ToDoDaoRepository;

public class ToDoKayitViewModel extends ViewModel {
    private ToDoDaoRepository trepo;
    public ToDoKayitViewModel(ToDoDaoRepository trepo){
        this.trepo = trepo;
    }

    public void kaydet(String name){
        trepo.kaydet(name);
    }

}
