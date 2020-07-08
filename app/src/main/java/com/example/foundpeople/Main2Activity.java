package com.example.foundpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {
Spinner age,height,eye_colour,hair_colour;
EditText name,box;
Button next;
String str,str1;
String age_ar[]={"Between 1 to 10","Between 10 to 20","Greater than 20","Don't exactly remember"};
String height_ar[]={"Less than 5feet","Between 5feet to 5.5feet","Between 5.5feet to 6feet","More than 6 feet","Don't exactly remember"};
String eye_color_ar[]={"Black","Brown","Blue","Grey","Don't exactly remember"};
String hair_colour_ar[]={"Black","Brown","Grey","Golden","Don't exactly remember"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        box=findViewById(R.id.box);
        name=findViewById(R.id.name);
        next=findViewById(R.id.next);
        age=findViewById(R.id.age_s);
        hair_colour=findViewById(R.id.hair_colour_s);
        height=findViewById(R.id.height_s);
        eye_colour=findViewById(R.id.eye_colour_s);
        ArrayAdapter<String> ey=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,eye_color_ar);
        ArrayAdapter<String> ha=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,hair_colour_ar);
        ArrayAdapter<String> he=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,height_ar);
        ArrayAdapter<String> ag=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,age_ar);
        eye_colour.setAdapter(ey);
        eye_colour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        hair_colour.setAdapter(ha);
        hair_colour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        height.setAdapter(he);
        height.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        age.setAdapter(ag);
        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Name=name.getText().toString();
                final String Box=box.getText().toString();
                final String Hair=hair_colour.getSelectedItem().toString();
                final String Height=height.getSelectedItem().toString();
                final String eyes=eye_colour.getSelectedItem().toString();
                final String Age=age.getSelectedItem().toString();

                if(TextUtils.isEmpty(Name))
                {
                    name.setError("name is Required");
                }
                else {
                    Intent found_next = new Intent(Main2Activity.this, Main5Activity.class);
                    found_next.putExtra("alias",Name);
                    found_next.putExtra("box",Box);
                    found_next.putExtra("hair",Hair);
                    found_next.putExtra("height",Height);
                    found_next.putExtra("eyes",eyes);
                    found_next.putExtra("age",Age);
                    startActivity(found_next);
                }
            }
        });
        str=name.getText().toString();
        str1=box.getText().toString();

    }
}
