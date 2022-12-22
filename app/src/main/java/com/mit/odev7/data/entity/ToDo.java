package com.mit.odev7.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "toDo")
public class ToDo implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int toDo_id;
    @ColumnInfo(name = "tDoname")
    @NonNull
    @Ignore
    private String name;

    public ToDo() {
    }

    public ToDo(int toDo_id, @NonNull String name) {
        this.toDo_id = toDo_id;
        this.name = name;
    }

    public int getToDo_id() {
        return toDo_id;
    }

    public void setToDo_id(int toDo_id) {
        this.toDo_id = toDo_id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
