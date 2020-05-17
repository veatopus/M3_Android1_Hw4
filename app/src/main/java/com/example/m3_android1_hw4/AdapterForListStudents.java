package com.example.m3_android1_hw4;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class AdapterForListStudents extends RecyclerView.Adapter<ViewHolderForListStudents> {
    private ArrayList<Student> listStudents = new ArrayList<>();

    int putElement(@NonNull Student student){
        listStudents.add(student);
        notifyDataSetChanged();
        Collections.sort(listStudents);
        return listStudents.size()-1;
    }

    @NonNull
    @Override
    public ViewHolderForListStudents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolderForListStudents(inflater.inflate(R.layout.item_for_list_students, parent, false));
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
