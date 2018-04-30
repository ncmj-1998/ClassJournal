package com.example.a16022671.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lvModule);
        ArrayList<String> gradeList = new ArrayList<String>();
        gradeList.add("A");
        gradeList.add("A");
        modules = new ArrayList<Module>();
        modules.add(new Module("C302","Web Services",gradeList));
        modules.add(new Module("C347","Android Programing II",gradeList));

        aa = new ModuleAdapter(this, R.layout.modulerow, modules);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedModule = modules.get(position);
                Intent i = new Intent(MainActivity.this,
                        GradeActivity.class);
                // Put hero object in intent
                i.putExtra("module", selectedModule);
                startActivity(i);
            }
        });


    }
}
