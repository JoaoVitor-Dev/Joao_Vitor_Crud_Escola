package com.example.joao_vitor_crud_room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "_school")
public class School {
    @PrimaryKey
    @ColumnInfo(name = "school_id")
    public Long Schoolid;
    @NonNull
    @ColumnInfo(name = "school_name")
    public String SchoolName;

    public School(){}

    @Ignore
    public School(String schoolName) {this.SchoolName = schoolName;}
}
