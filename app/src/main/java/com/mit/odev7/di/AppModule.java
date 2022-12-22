package com.mit.odev7.di;

import android.content.Context;

import androidx.room.Room;

import com.mit.odev7.data.repo.ToDoDaoRepository;
import com.mit.odev7.room.ToDoDao;
import com.mit.odev7.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public ToDoDaoRepository provideKisilerDaoRepository(ToDoDao toDoDao){
        return new ToDoDaoRepository(toDoDao);
    }

    @Provides
    @Singleton
    public ToDoDao provideToDoDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context,Veritabani.class,"odev7db.sqlite")
                .createFromAsset("odev7db.sqlite").build();
        return vt.getToDoDao();
    }
}
