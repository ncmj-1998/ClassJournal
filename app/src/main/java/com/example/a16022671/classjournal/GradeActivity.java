package com.example.a16022671.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GradeActivity extends AppCompatActivity {
 ListView lvGrade;
    ArrayAdapter aa;
    ArrayList<Grade> grades;

    Button btnInfo;

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

        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("https://www.rp.edu.sg/SOI/full-time-diplomas/Details/r47"));
                startActivity(rpIntent);
            }
        });
    }
}
