package com.mit.odev7.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mit.odev7.data.entity.ToDo;
import com.mit.odev7.data.repo.ToDoDaoRepository;

import java.util.List;

import javax.inject.Inject;

public class AnasayfaViewModel extends ViewModel {
    private ToDoDaoRepository trepo;
    public MutableLiveData<List<ToDo>> toDoListesi = new MutableLiveData<>();
    @Inject
    public AnasayfaViewModel(ToDoDaoRepository trepo){
        this.trepo = trepo;
        toDoYukle();
        toDoListesi = trepo.getTodoListesi();
    }

    public void ara(String aramaKelimesi){
        trepo.ara(aramaKelimesi);
    }

    public void sil(int name){
        trepo.sil(name);
    }

    public void toDoYukle(){
        trepo.toDoYukle();
    }
}
