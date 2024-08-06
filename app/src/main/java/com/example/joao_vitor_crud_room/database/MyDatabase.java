package com.example.joao_vitor_crud_room.database;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.joao_vitor_crud_room.dao.AllDao;
import com.example.joao_vitor_crud_room.entities.Classe;
import com.example.joao_vitor_crud_room.entities.School;
import com.example.joao_vitor_crud_room.entities.Student;

@Database(entities = {School.class, Classe.class, Student.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract AllDao allDao();
}
