package com.example.joao_vitor_crud_room.dao;

import androidx.room.Embedded;
import com.example.joao_vitor_crud_room.entities.Student;

public class StudentAndSchoolAndClass
{
    @Embedded
    public Student student;
    public String school_name;
    public String classe_name;
}
