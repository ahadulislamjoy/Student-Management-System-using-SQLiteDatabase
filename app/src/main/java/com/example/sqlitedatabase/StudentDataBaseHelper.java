package com.example.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class StudentDataBaseHelper extends SQLiteOpenHelper {

    Context context;
    public static final String DATABASE_NAME = "student.db";
    public static final int DATABASE_VERSION = 2;

    public static final String STUDENT_TABLE = "student_table ";

    public static final String COL_ID = "_id ";
    public static final String COL_NAME = "name ";
    public static final String COL_AGE = "age ";
    public static final String COL_ADDRESS = "address ";
    public static final String CREATE_TABLE ="CREATE TABLE "+STUDENT_TABLE+" (" +COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_NAME+" VARCHAR(255),"+COL_AGE+" INTEGER,"+COL_ADDRESS+" VARCHAR(255)"+" )" ;
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " +STUDENT_TABLE;
   // public static final String CREATE_TABLE = " create table users (_id integer primary key autoincrement, name text, username text, password text )";

    public StudentDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
//        try {
//
//            Toast.makeText(context, "table create", Toast.LENGTH_SHORT).show();
//
//        }catch (Exception e){
//            Toast.makeText(context, "Exception"+e, Toast.LENGTH_SHORT).show();
//
//        }
   }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DROP_TABLE);
            this.onCreate(sqLiteDatabase);
        }
//        try {
//            Toast.makeText(context, "table update", Toast.LENGTH_SHORT).show();
//            sqLiteDatabase.execSQL(DROP_TABLE);
//            this.onCreate(sqLiteDatabase);
//
//        }catch (Exception e){
//            Toast.makeText(context, "Exception"+e, Toast.LENGTH_SHORT).show();
//        }

    }
