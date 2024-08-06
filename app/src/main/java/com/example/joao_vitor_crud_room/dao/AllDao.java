package com.example.joao_vitor_crud_room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.joao_vitor_crud_room.entities.Classe;
import com.example.joao_vitor_crud_room.entities.School;
import com.example.joao_vitor_crud_room.entities.Student;

import java.util.List;

@Dao
public interface AllDao
{
    @Insert
    Long insertSchool(School s);
    @Insert
    Long insertClass(Classe c);
    @Insert
    Long insertStudent(Student s);


    @Query("SELECT * FROM _school")
    List<School> getAllSchools();


    @Query("SELECT * FROM _school WHERE school_id = :school_id ")
    School getSchoolById(Long school_id);


    @Query("SELECT * FROM _classe")
    List<Classe> getAllClasses();


    @Query("SELECT * FROM _classe WHERE classe_id = :classe_id")
    Classe getClassById(Long classe_id);


    @Query("SELECT * FROM _student " +
            "JOIN _school ON _school.school_id = _student.school_id " +
            "JOIN _classe ON _classe.classe_id = _student.classe_id")
    List<StudentAndSchoolAndClass> getStudentAndSchoolAndClass();
    @Query("SELECT * FROM _student")
    List<StudentWithSchoolWithClass> getStudentWithSchoolWithClass();
}
