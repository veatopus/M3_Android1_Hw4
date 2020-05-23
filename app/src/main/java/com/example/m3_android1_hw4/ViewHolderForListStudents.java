package com.example.m3_android1_hw4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolderForListStudents extends RecyclerView.ViewHolder {
    private TextView fullName;
    private TextView phoneNumber;
    private TextView group;
    IStudentClick listener;
    private Student s;

    ViewHolderForListStudents(@NonNull View itemView) {
        super(itemView);
        fullName = itemView.findViewById(R.id.vh_student_full_name);
        phoneNumber = itemView.findViewById(R.id.vh_student_phone_number);
        group = itemView.findViewById(R.id.vh_student_group);
        ImageView icon = itemView.findViewById(R.id.vh_student_icon_of_student);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fullName.getText().toString().equals("") && !phoneNumber.getText().toString().equals("") && !group.getText().toString().equals("")){
                    Student student = new Student(fullName.getText().toString(), phoneNumber.getText().toString(), group.getText().toString());
                    student.setID(s.getId());
                    listener.onStudentClick(s);
            }
            }
        });

    }

    void onBind(@NonNull Student student){
        s = student;
        putStudentInXmlFile(student);
    }

    private void putStudentInXmlFile(@NonNull Student student){
        fullName.setText(student.getFullName());
        phoneNumber.setText(student.getPhoneNumber());
        group.setText(student.getGroup());
        if (fullName.getText() != null && phoneNumber.getText() != null) {
            group.getText();
        }
    }
}