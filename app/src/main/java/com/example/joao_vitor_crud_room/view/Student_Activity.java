package com.example.joao_vitor_crud_room.view;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.joao_vitor_crud_room.R;
import com.example.joao_vitor_crud_room.adapter.StudentAdapter;

public class Student_Activity extends AppCompatActivity
{
    private Button btnVoltar, btnNovo;
    private StudentAdapter adapter;

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
                startActivity((new Intent(Student_Activity.this, MainActivity.class)));
            }
        });

    }

    private void setup()
    {
        btnNovo = findViewById(R.id.btnNovo);
        btnVoltar = findViewById(R.id.btnVoltar);
    }
}