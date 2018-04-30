package com.example.a16022671.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter<Grade> {

    private ArrayList<Grade> grades;
    private Context context;
    private TextView tvGrade;
    private  TextView tvHeader;



    public GradeAdapter(Context context, int resource, ArrayList<Grade> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        grades = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.graderow, parent, false);

        // Get the TextView object
        tvGrade = (TextView) rowView.findViewById(R.id.tvGrade);

        Grade currentGrade = grades.get(position);
        // Set the TextView to show the food

        tvHeader = (TextView)rowView.findViewById(R.id.tvHeader);
        int week = position +1;
        tvHeader.setText("Week "+ String.valueOf(week));
        tvGrade.setText(currentGrade.getGrade());

        return rowView;
    }

}
