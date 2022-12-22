package com.mit.odev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.mit.odev7.data.repo.ToDoDaoRepository;

import javax.inject.Inject;

public class TodoDetayViewModel extends ViewModel {
    private ToDoDaoRepository trepo;

    @Inject
    public TodoDetayViewModel(ToDoDaoRepository krepo){
        this.trepo = trepo;
    }

    public void guncelle(int id,String name){
        trepo.guncelle(id,name);
    }
}
