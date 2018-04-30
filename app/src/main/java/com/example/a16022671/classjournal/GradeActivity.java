package com.example.a16022671.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GradeActivity extends AppCompatActivity {
 ListView lvGrade;
 Button buttonAdd;

    ArrayAdapter aa;
    ArrayList<Grade> grades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        lvGrade = (ListView)findViewById(R.id.lvGrade);
        buttonAdd = (Button)findViewById(R.id.btnAdd);

        ArrayList<String> gradeList = new ArrayList<String>();
        grades = new ArrayList<Grade>();

        // Get the intent
        final Intent i = getIntent();
        // Get the Hero object first activity put in Intent
         final Module module = (Module) i.getSerializableExtra("module");
        grades = new ArrayList<Grade>();
        for (int a=0;a<module.getDailyGrade().size();a++){
                grades.add(new Grade(module.getDailyGrade().get(a)));

        }
        aa = new GradeAdapter(this, R.layout.graderow, grades);
        lvGrade.setAdapter(aa);


        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(GradeActivity.this,
                        AddGradeActivity.class);
                // Put hero object in intent
                i.putExtra("module", module);

                startActivity(i);

                       }});

    }
}
