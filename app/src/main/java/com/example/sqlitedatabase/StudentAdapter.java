package com.example.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<StudentModel> {
    Context context;
    ArrayList<StudentModel> arrayList;
    public StudentAdapter(@NonNull Context context, ArrayList<StudentModel> arrayList) {
        super(context, R.layout.single_student_row,arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.single_student_row,parent,false);
        TextView nameTV = v.findViewById(R.id.nameTextId);
        TextView ageTV = v.findViewById(R.id.ageTextId);
        TextView addressTV = v.findViewById(R.id.addressTextId);

        nameTV.setText("  "+arrayList.get(position).name);
        ageTV.setText("  "+arrayList.get(position).age);
        addressTV.setText("  "+arrayList.get(position).address);
        return v;
    }
}
