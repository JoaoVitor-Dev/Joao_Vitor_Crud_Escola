package com.example.joao_vitor_crud_room.entities;

import androidx.room.*;

@Entity(
        tableName = "_student", foreignKeys = {
        @ForeignKey(
                entity = School.class,
                parentColumns = {"school_id"},
                childColumns = {"school_id"},
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Classe.class,
                parentColumns = {"classe_id"},
                childColumns = {"classe_id"},
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )
}
)
public class Student {
    @PrimaryKey
    @ColumnInfo(name = "student_id")
    public Long StudentId;
    @ColumnInfo(name = "Student_name")
    public String StudentName;
    @ColumnInfo(name = "school_id", index = true)
    public Long SchoolId;
    @ColumnInfo(name = "classe_id", index = true)
    public Long ClasseId;

    public Student(){}


    @Ignore
    public Student(String studentName, long schoolId, long classId) {
        this.StudentName = studentName;
        this.SchoolId = schoolId;
        this.ClasseId = classId;
    }
}

