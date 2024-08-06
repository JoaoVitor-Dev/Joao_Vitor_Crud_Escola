package com.example.joao_vitor_crud_room;

import android.os.Bundle;

import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import com.example.joao_vitor_crud_room.dao.AllDao;
import com.example.joao_vitor_crud_room.dao.StudentAndSchoolAndClass;
import com.example.joao_vitor_crud_room.dao.StudentWithSchoolWithClass;
import com.example.joao_vitor_crud_room.database.MyDatabase;
import com.example.joao_vitor_crud_room.entities.Classe;
import com.example.joao_vitor_crud_room.entities.School;
import com.example.joao_vitor_crud_room.entities.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    MyDatabase db;
    AllDao allDao;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Build the MyDatabase instance
        db = Room.databaseBuilder(this, MyDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();
        // Build the allDao instance
        allDao = db.allDao();


        // Create some school objects
        School[] s_array = {new School("School1"),
                new School("School2"),
                new School("School3")
        };
        // Insert the Schools into the database
        for (School s : s_array) {
            allDao.insertSchool(s);
        }


        // Create some Class objects
        Classe[] c_array = {
                new Classe("Class1"),
                new Classe("Class2"),
                new Classe("Class3")
        };
        // Insert the classes
        for (Classe c : c_array) {
            allDao.insertClass(c);
        }


        // Create some Student Objects
        Student[] st_array = {
                new Student("Fred", 3, 3),
                new Student("Mary", 1, 2)
        };
        //Insert the Students
        for (Student st : st_array) {
            allDao.insertStudent(st);
        }


        // Get the Students with the School and Class information using POJO 1 (realtionship via joins)
        List<StudentAndSchoolAndClass> sasac = allDao.getStudentAndSchoolAndClass();
        // Log the data
        for (StudentAndSchoolAndClass ssc : sasac) {
            Log.d("STUDENTINFO1", "Student Name = " + ssc.student.StudentName +
                    "\n\t ID=" + ssc.student.StudentId + " SchoolID=" + ssc.student.SchoolId + " ClassID=" + ssc.student.ClasseId +
                    "\n\t\t School Name = " + ssc.school_name +
                    "\n\t\t Class Name = " + ssc.classe_name
            );
        }
        // Get the Students with the School and Class information using POJO 2 (with @Relation's)
        List<StudentWithSchoolWithClass> swswc = allDao.getStudentWithSchoolWithClass();
        for (StudentWithSchoolWithClass ssc : swswc) {
            Log.d("STUDENTINFO2", "Student Name = " + ssc.student.StudentName +
                    "\n\t ID=" + ssc.student.StudentId + " SchoolID=" + ssc.student.SchoolId +
                    " ClassID=" + ssc.student.ClasseId +
                    "\n\t\t School Name = " + ssc.schoolList.get(0).SchoolName +
                    "\n\t\t Class Name = " + ssc.classeList.get(0).classeName
            );
        }
    }//onCreate

}