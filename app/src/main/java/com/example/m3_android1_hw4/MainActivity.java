package com.example.m3_android1_hw4;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    AdapterForListStudents adapterForListStudents = new AdapterForListStudents();
    Button addNewStudent;
    RecyclerView recyclerView;
    public static final String PUT_EXTRA_MAIN_ACTIVITY = "key for put extra MainActivity";
    private static final int REQUEST_CODE_FOR_ACTIVITY_FOR_ADD_STUDENTS = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_students_list);

        recyclerView.setAdapter(adapterForListStudents);

        addNewStudent = findViewById(R.id.addStudent);

        addNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addNewStudent = new Intent(MainActivity.this, ActivityForAddStudents.class);
                startActivityForResult(addNewStudent, REQUEST_CODE_FOR_ACTIVITY_FOR_ADD_STUDENTS);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FOR_ACTIVITY_FOR_ADD_STUDENTS) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                int position = adapterForListStudents.putElement((Student) Objects.requireNonNull(data.getSerializableExtra(PUT_EXTRA_MAIN_ACTIVITY)));
                recyclerView.scrollToPosition(position);
            }
        }
    }
}
