package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class StudentDatabaseSource {
    StudentDataBaseHelper studentDataBaseHelper;
    SQLiteDatabase sqLiteDatabase;
    StudentModel studentModel;

   public StudentDatabaseSource(Context context){
        studentDataBaseHelper = new StudentDataBaseHelper(context);
    }
    public void open(){
        sqLiteDatabase=studentDataBaseHelper.getWritableDatabase();
    }
    public void close(){
        studentDataBaseHelper.close();
    }


    public boolean addStudent(StudentModel studentModel){
        this.open();
        ContentValues contentValues  = new ContentValues();
        contentValues.put(studentDataBaseHelper.COL_NAME,studentModel.getName());
        contentValues.put(studentDataBaseHelper.COL_AGE,studentModel.getAge());
        contentValues.put(studentDataBaseHelper.COL_ADDRESS,studentModel.getAddress());
        Long insertRow = sqLiteDatabase.insert(studentDataBaseHelper.STUDENT_TABLE,null,contentValues);
        this.close();
        if (insertRow>0){
            return true;
        }else return false;
    }
    public ArrayList<StudentModel> getArrayList(){
       this.open();
       ArrayList<StudentModel> arrayList = new ArrayList<>();
       Cursor cursor = sqLiteDatabase.query(studentDataBaseHelper.STUDENT_TABLE,null,null,null,null,null,null);
       if(cursor.moveToFirst()){
           do{
               //cursor.getString(cursor.getColumnIndex(studentDataBaseHelper.COL_AGE.toString()));

              String name = cursor.getString(1);
              int age = cursor.getInt(2);
              String address = cursor.getString(3);
              StudentModel studentModel = new StudentModel(name,age,address);
              arrayList.add(studentModel);

           }while (cursor.moveToNext());
       }
       this.close();
       cursor.close();
       return arrayList;
    }
}
