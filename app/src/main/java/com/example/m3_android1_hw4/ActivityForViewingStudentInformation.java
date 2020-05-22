package com.example.m3_android1_hw4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityForViewingStudentInformation extends AppCompatActivity {
    static final String KEY_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION = "key_for_student_activity_viewing_student_information";
    public static final String PUT_EXTRA_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION = "key_for_put_extra_MainActivity";
    private final int REQUEST_CODE_FOR_STUDENT_EDITING = 42;
    Button back;
    Button editing;
    Button save;
    TextView name;
    TextView numberPhone;
    TextView group;
    Student s;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_viewing_student_information);

        if (getIntent() != null)
            intent = getIntent();

        initialization();
        fillingInInformation(s);
        setOnClickListeners();


    }

    public void initialization(){
        s = (Student) getIntent().getSerializableExtra(KEY_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION);
        name = findViewById(R.id.nameStudent);
        numberPhone = findViewById(R.id.numberOfPhoneStudent);
        group = findViewById(R.id.groupStudent);
        back = findViewById(R.id.btn_back);
        editing = findViewById(R.id.btn_editing);
        save = findViewById(R.id.btn_save);
    }

    public void fillingInInformation(Student s){
        assert s != null;
        name.setText(s.getFullName());
        numberPhone.setText(s.getPhoneNumber());
        group.setText(s.getGroup());
    }


    public void setOnClickListeners(){

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityForViewingStudentInformation.this, StudentEditing.class);
                intent.putExtra(StudentEditing.PUT_EXTRA_FOR_STUDENT_STUDENT_EDITING, s);
                startActivityForResult(intent, REQUEST_CODE_FOR_STUDENT_EDITING);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().equals("") && !numberPhone.getText().toString().equals("") && !group.getText().toString().equals("")) {
                    Student student = new Student(name.getText().toString(), numberPhone.getText().toString(), group.getText().toString());
                    assert intent != null;
                    intent.putExtra(MainActivity.PUT_EXTRA_MAIN_ACTIVITY, student);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(ActivityForViewingStudentInformation.this, "не все поля запонены", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_FOR_STUDENT_EDITING){
            if (resultCode == RESULT_OK){
                assert data != null;
                Student s = (Student) data.getSerializableExtra(PUT_EXTRA_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION);
                assert s != null;
                fillingInInformation(s);
            }
        }
    }
}