package com.example.m3_android1_hw4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolderForListStudents extends RecyclerView.ViewHolder {
    private TextView fullName;
    private TextView phoneNumber;
    private TextView group;

    ViewHolderForListStudents(@NonNull View itemView) {
        super(itemView);
        fullName = itemView.findViewById(R.id.vh_student_full_name);
        phoneNumber = itemView.findViewById(R.id.vh_student_phone_number);
        group = itemView.findViewById(R.id.vh_student_group);
    }

    void onBind(Student student){
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
