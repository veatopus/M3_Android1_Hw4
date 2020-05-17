package com.example.m3_android1_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityForAddStudents extends AppCompatActivity {
    EditText addName;
    EditText addPhone;
    EditText addGroup;
    Button saveStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_add_students);
        addName = findViewById(R.id.addName);
        addPhone = findViewById(R.id.addNumberOfPhone);
        addGroup = findViewById(R.id.addGroup);
        saveStudent = findViewById(R.id.saveStudent);
        final Intent intent = getIntent();
        if (intent == null)
            finish();
        saveStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!addName.getText().toString().equals("") && !addPhone.getText().toString().equals("") && !addGroup.getText().toString().equals("")) {
                    Student student = new Student(addName.getText().toString(), addPhone.getText().toString(), addGroup.getText().toString());
                    assert intent != null;
                    intent.putExtra(MainActivity.PUT_EXTRA_MAIN_ACTIVITY, student);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(ActivityForAddStudents.this, "не все поля запонены", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
