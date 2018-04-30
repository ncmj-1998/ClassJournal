package com.example.a16022671.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GradeActivity extends AppCompatActivity {
 ListView lvGrade;
    ArrayAdapter aa;
    ArrayList<Grade> grades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        lvGrade = (ListView)findViewById(R.id.lvGrade);

        // Get the intent
        Intent i = getIntent();
        // Get the Hero object first activity put in Intent
        Module module = (Module) i.getSerializableExtra("module");
        grades = new ArrayList<Grade>();
        for (int a=0;a<module.getDailyGrade().size();a++){
                grades.add(new Grade(module.getDailyGrade().get(a)));

        }
        aa = new GradeAdapter(this, R.layout.graderow, grades);
        lvGrade.setAdapter(aa);
    }
}
