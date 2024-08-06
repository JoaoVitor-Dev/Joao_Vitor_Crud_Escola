package com.example.joao_vitor_crud_room.dao;

import androidx.room.Embedded;
import androidx.room.Relation;
import com.example.joao_vitor_crud_room.entities.Classe;
import com.example.joao_vitor_crud_room.entities.School;
import com.example.joao_vitor_crud_room.entities.Student;

import java.util.List;

public class StudentWithSchoolWithClass
{
    @Embedded
    public Student student;
    @Relation(entity = School.class,parentColumn = "school_id", entityColumn = "school_id")
    public List<School> schoolList;
    @Relation(entity = Classe.class,parentColumn = "classe_id",entityColumn = "classe_id")
    public List<Classe> classeList;
}
