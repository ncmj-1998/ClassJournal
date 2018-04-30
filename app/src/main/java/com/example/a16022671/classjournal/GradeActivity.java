package com.example.a16022671.classjournal;

import android.content.Intent;
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
    Button btnEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        lvGrade = (ListView)findViewById(R.id.lvGrade);

        btnEmail = (Button) findViewById(R.id.btnEmail);

        // Get the intent
        Intent i = getIntent();
        // Get the Hero object first activity put in Intent
        Module module = (Module) i.getSerializableExtra("module");
        grades = new ArrayList<Grade>();

       if (module.getDailyGrade() == null){

       }
        else {
           for (int a = 0; a < module.getDailyGrade().size(); a++) {
               grades.add(new Grade(module.getDailyGrade().get(a)));
           }
       }
        aa = new GradeAdapter(this, R.layout.graderow, grades);
        lvGrade.setAdapter(aa);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
//                email.putExtra(Intent.EXTRA_SUBJECT,
//                        "Test Email from C347");

                //retrieving the week and grade
                String message = "Hi faci, \n" + "Please see my remarks so far, thank you!\n";
                String week = null;
                for (int i = 0; i < grades.size(); i++) {
                    week = String.valueOf(i + 1);
                    String grade = grades.get(i).getGrade();
                    message += "\nWeek: " + week + " DG: " + grade;
                }
                ;

                email.putExtra(Intent.EXTRA_TEXT,
                        message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });


    }}
