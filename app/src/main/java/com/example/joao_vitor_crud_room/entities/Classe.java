package com.example.joao_vitor_crud_room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "_classe")
public class Classe {
    @PrimaryKey
    @ColumnInfo(name = "classe_id")
    public Long classeId;

    @NonNull
    @ColumnInfo(name = "classe_name")
    public String classeName;

    public Classe(){}
    @Ignore
    public Classe(String className) {
        this.classeName = className;
    }

}
