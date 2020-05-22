package com.example.m3_android1_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentEditing extends AppCompatActivity {
    EditText addName;
    EditText addPhone;
    EditText addGroup;
    Button saveStudent;
    Button back;
    public static final String PUT_EXTRA_FOR_STUDENT_STUDENT_EDITING = "put_extra_for_student_student_editing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_editing);

        addName = findViewById(R.id.studentEditing_addName);
        addPhone = findViewById(R.id.studentEditing_addNumberOfPhone);
        addGroup = findViewById(R.id.studentEditing_addGroup);
        saveStudent = findViewById(R.id.studentEditing_saveStudent);
        back = findViewById(R.id.studentEditing_btn_back);


        Intent intent = getIntent();
        Student s = (Student) intent.getSerializableExtra(PUT_EXTRA_FOR_STUDENT_STUDENT_EDITING);
        assert s != null;
        addName.setText(s.getFullName());
        addPhone.setText(s.getPhoneNumber());
        addGroup.setText(s.getGroup());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = getIntent();
                if (!addName.getText().toString().equals("") && !addPhone.getText().toString().equals("") && !addGroup.getText().toString().equals("")) {
                    Student student = new Student(addName.getText().toString(), addPhone.getText().toString(), addGroup.getText().toString());
                    assert intent != null;
                    intent.putExtra(ActivityForViewingStudentInformation.PUT_EXTRA_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION, student);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(StudentEditing.this, "не все поля запонены", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
