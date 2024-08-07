package com.example.joao_vitor_crud_room.view;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import com.example.joao_vitor_crud_room.R;
import com.example.joao_vitor_crud_room.adapter.StudentAdapter;
import com.example.joao_vitor_crud_room.dao.AllDao;
import com.example.joao_vitor_crud_room.dao.StudentWithSchoolWithClass;
import com.example.joao_vitor_crud_room.database.MyDatabase;

public class Student_Activity extends AppCompatActivity implements StudentAdapter.OnClickListener
{
    private MyDatabase db;
    private AllDao allDao;
    private Button btnVoltar, btnNovo;
    private StudentAdapter adapter;
    private RecyclerView rvStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();

        btnVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity((new Intent(Student_Activity.this, MainActivity.class)));
            }
        });

        btnNovo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity((new Intent(Student_Activity.this, New_Student_Activity.class)));
            }
        });

        listStudents();

    }

    private void setup()
    {
        btnNovo = findViewById(R.id.btnNovo);
        btnVoltar = findViewById(R.id.btnVoltar);
        rvStudents = findViewById(R.id.rvStudents);

        // Build the MyDatabase instance
        db = Room.databaseBuilder(this, MyDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();
        // Build the allDao instance
        allDao = db.allDao();
    }

    private void listStudents()
    {
        adapter = new StudentAdapter(allDao.getStudentWithSchoolWithClass(), null, this);

        rvStudents.setAdapter(adapter);
    }

    @Override
    public void onClick(StudentWithSchoolWithClass student)
    {
        Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show();
    }
}