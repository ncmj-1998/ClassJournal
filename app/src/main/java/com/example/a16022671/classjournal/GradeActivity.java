package com.example.a16022671.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    Button btnEmail;
    Button btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        lvGrade = (ListView)findViewById(R.id.lvGrade);
        buttonAdd = (Button)findViewById(R.id.btnAdd);

        ArrayList<String> gradeList = new ArrayList<String>();
        grades = new ArrayList<Grade>();

        btnEmail = (Button) findViewById(R.id.btnEmail);

        // Get the intent
        final Intent i = getIntent();
        // Get the Hero object first activity put in Intent
        final Module module = (Module) i.getSerializableExtra("module");
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


        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.

                String url = "https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/";
                rpIntent.setData(Uri.parse(url+module.getModuleCode()));
                startActivity(rpIntent);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(GradeActivity.this,
                        AddGradeActivity.class);
                // Put hero object in intent
                i.putExtra("module", module);

                startActivity(i);

            }});

    }}




