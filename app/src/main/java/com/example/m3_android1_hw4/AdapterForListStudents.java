
package com.example.m3_android1_hw4;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class AdapterForListStudents extends RecyclerView.Adapter<ViewHolderForListStudents> {
    private static ArrayList<Student> listStudents = new ArrayList<>();
    IStudentClick listener;

    void studentReplacement(@NonNull Student student){
        for (int i = 0; i <= listStudents.size()-1; i++) {
            Log.d("ololo", "studentReplacement: poisk " + i + " " + listStudents.get(i).getId());
            if (student.getId() == listStudents.get(i).getId()){
                Log.d("ololo", "studentReplacement: poisk zavershon" + i + " " + listStudents.get(i).getId());
                listStudents.remove(i);
                listStudents.add(i, student);
                Collections.sort(listStudents);
                notifyDataSetChanged();
                Log.d("ololo", "studentReplacement: activ "+ student.getId() + " " + listStudents.get(i).getId());
                break;
            }
        }
    }

    int putElement(@NonNull Student student){
        student.setID(student.hashCode());
        listStudents.add(student);
        Collections.sort(listStudents);
        notifyDataSetChanged();
        return listStudents.size()-1;
    }

    @NonNull
    @Override
    public ViewHolderForListStudents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderForListStudents v = new ViewHolderForListStudents(inflater.inflate(R.layout.item_for_list_students, parent, false));
        v.listener = listener;
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForListStudents holder, int position) {
        holder.onBind(listStudents.get(position));
    }

    @Override
    public int getItemCount() {
        return listStudents.size();
    }
}
