package com.example.sqlitedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {
    StudentDatabaseSource source;
    public ListView listView;
    ArrayList<StudentModel> arrayList;
    public static final int DELETE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        listView = findViewById(R.id.listViewId);

        source = new StudentDatabaseSource(this);
        arrayList=source.getArrayList();
        StudentAdapter studentAdapter = new StudentAdapter(this,arrayList);
        listView.setAdapter(studentAdapter);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StudentModel studentModel=arrayList.get(i);
                Intent intent = new Intent(StudentListActivity.this,MainActivity.class);
                intent.putExtra("STUDENT",studentModel);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu,menu);
        menu.add(0,DELETE,menu.NONE,"Delete From Database");
        menu.setHeaderTitle("Delete Student");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == DELETE){
            boolean status = source.deleteStudent(arrayList.get(adapterContextMenuInfo.position));
            if (status){
                Toast.makeText(this, "delete successfully", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "delete Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onContextItemSelected(item);
    }
}