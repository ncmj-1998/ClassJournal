package com.example.a16022671.classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AddGradeActivity extends AppCompatActivity {

    TextView tvWeek;
    ImageView imgView;
    RadioGroup rg;
    Button ButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        tvWeek = (TextView)findViewById(R.id.textWeek);
        imgView = (ImageView) findViewById(R.id.imageView2);
        rg = (RadioGroup) findViewById(R.id.rg);
        ButtonSubmit = (Button) findViewById(R.id.btnSubmit);

        final Intent i = getIntent();
        // Get the Hero object first activity put in Intent
        final Module module = (Module) i.getSerializableExtra("module");

        String newWeek = "Week 1";

        if (module.getDailyGrade()==null){

        }else{
            for (int a=0;a<module.getDailyGrade().size();a++){
                newWeek = String.valueOf(a+2);
            }
        }
    tvWeek.setText("Week " + newWeek);

        ButtonSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                String grade = rb.getText().toString();
                if (module.getDailyGrade()!=null){
                    module.addToArray(grade);
                }else{
                    ArrayList<String> gradeList = new ArrayList<String>();
                    gradeList.add(grade);

                    module.setDailyGrade(gradeList);
                }
                Log.v("add success",String.valueOf(module.getDailyGrade()));


                Intent i = new Intent();
                i.putExtra("module", module);

                setResult(RESULT_OK, i);

                finish();

            }});




    }





}
