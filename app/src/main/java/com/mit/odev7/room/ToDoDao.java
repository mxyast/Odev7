package com.mit.odev7.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mit.odev7.data.entity.ToDo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
@Dao
public interface ToDoDao {
    @Query("SELECT * FROM toDo")
    Single<List<ToDo>> toDoYukle();

    @Query("SELECT * FROM toDo WHERE 'toDoname' like '%'||:aramaKelmesi ||'%'")
    Single<List<ToDo>> ara(String aramaKelmesi);

    @Delete
    Completable sil(ToDo toDo);

    @Insert
    Completable kaydet(ToDo toDo);

    @Update
    Completable guncelle(ToDo toDo);
}
