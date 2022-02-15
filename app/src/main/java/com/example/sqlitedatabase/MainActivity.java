package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText nameEditText,ageEditText,addressEditText;
     Button addButton,showButton;
     StudentDatabaseSource studentDatabaseSource;
     StudentModel studentModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDatabaseSource = new StudentDatabaseSource(this);
        //studentDataBaseHelper = new StudentDataBaseHelper(this);
        //SQLiteDatabase sqLiteDatabase = studentDataBaseHelper.getReadableDatabase();

        nameEditText=findViewById(R.id.nameId);
        ageEditText=findViewById(R.id.ageId);
        addressEditText=findViewById(R.id.addressId);
        addButton=findViewById(R.id.addButtonId);
        showButton=findViewById(R.id.showButtonId);

         studentModel = (StudentModel) getIntent().getSerializableExtra("STUDENT");
         if(studentModel != null){
             addButton.setText("UPDATE BUTTON");
             nameEditText.setText(studentModel.name);
             ageEditText.setText(String.valueOf(studentModel.age));
             addressEditText.setText(studentModel.address);
         }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (studentModel != null){
                    int id = studentModel.id;
                    String updateName = nameEditText.getText().toString();
                    int updateAge = Integer.valueOf(ageEditText.getText().toString());
                    String updateAddress = addressEditText.getText().toString();
                    StudentModel updateStudentModel = new StudentModel(id,updateName,updateAge,updateAddress);
                    boolean updateStudentStatus = studentDatabaseSource.updateStudent(updateStudentModel);
                    if (updateStudentStatus){
                        Toast.makeText(MainActivity.this, "update", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "not update", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                        StudentModel studentModel = new StudentModel(nameEditText.getText().toString(),Integer.valueOf(ageEditText.getText().toString()),addressEditText.getText().toString());
                        Boolean status = studentDatabaseSource.addStudent(studentModel);
                        if (status){
                            Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "not saved", Toast.LENGTH_SHORT).show();
                        }

                    }
            }

        });
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StudentListActivity.class);
                startActivity(intent);
            }
        });


    }
}