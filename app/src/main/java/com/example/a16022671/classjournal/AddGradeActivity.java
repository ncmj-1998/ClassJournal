package com.example.a16022671.classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

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
    tvWeek.setText(newWeek);

        ButtonSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "dislike");
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // dislike
                setResult(RESULT_OK, i);
                finish();
            }});




    }





}
