package com.mit.odev7.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.mit.odev7.data.entity.ToDo;
import com.mit.odev7.room.ToDoDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ToDoDaoRepository {
    private MutableLiveData<List<ToDo>> todoListesi;
    private ToDoDao toDoDao;

    public ToDoDaoRepository( ToDoDao toDoDao){
        this.toDoDao=toDoDao;
        todoListesi=new MutableLiveData<>();
    }
    public MutableLiveData<List<ToDo>> getTodoListesi(){
        return todoListesi;
    }
    public void toDoYukle(){
        toDoDao.toDoYukle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ToDo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ToDo> toDos) {
                        todoListesi.setValue(toDos);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void kaydet(String name){
        ToDo yeniToDo = new ToDo(0,name);
        toDoDao.kaydet(yeniToDo).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void guncelle(int id,String name){
        ToDo guncellenenToDo = new ToDo(id,name);
        toDoDao.guncelle(guncellenenToDo).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void ara(String aramaKelimesi){
        toDoDao.ara(aramaKelimesi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ToDo>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ToDo> toDos) {
                        todoListesi.setValue(toDos);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    public void sil(int id){
        ToDo silinenToDo = new ToDo(id,"");
        toDoDao.sil(silinenToDo).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {
                        toDoYukle();
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

}
