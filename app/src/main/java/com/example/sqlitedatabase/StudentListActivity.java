package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class StudentListActivity extends AppCompatActivity {
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        listView = findViewById(R.id.listViewId);

        StudentDatabaseSource studentDatabaseSource = new StudentDatabaseSource(this);
        StudentAdapter studentAdapter = new StudentAdapter(this,studentDatabaseSource.getArrayList());
        listView.setAdapter(studentAdapter);

    }
}