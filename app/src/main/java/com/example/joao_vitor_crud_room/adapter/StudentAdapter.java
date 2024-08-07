package com.example.joao_vitor_crud_room.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.joao_vitor_crud_room.R;
import com.example.joao_vitor_crud_room.dao.StudentWithSchoolWithClass;
import com.example.joao_vitor_crud_room.entities.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder>
{

    private List<StudentWithSchoolWithClass> studentList;
    private Context context;
    private OnClickListener clickListener;

    public StudentAdapter(List<StudentWithSchoolWithClass> studentList, Context context, OnClickListener clickListener)
    {
        this.studentList = studentList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_student, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        StudentWithSchoolWithClass student = studentList.get(position);

        holder.textNome.setText(student.student.StudentName);
        holder.textDisciplina.setText((CharSequence) student.classeList.get(Math.toIntExact(student.student.ClasseId)));

        holder.btnDetalhes.setOnClickListener(v -> clickListener.onClick(student));
    }

    @Override
    public int getItemCount()
    {
        return studentList.size();
    }

    public interface OnClickListener
    {
        void onClick(StudentWithSchoolWithClass student);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView textNome, textDisciplina;
        Button btnDetalhes;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            textDisciplina = itemView.findViewById(R.id.textDisciplina);
            btnDetalhes = itemView.findViewById(R.id.btnDetalhes);

        }
    }
}
