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

public class Main7Activity extends AppCompatActivity {
    EditText phone,email,name;
    Button next;
    Spinner rela,bod,comp;
    String rel[]={"None","father","mother","brother","sister","uncle","aunt"};
    String bo[]={"mesomorph(Well defined muscles)","ectomorph(Long and lean)","endomorph(Wider body)","Don't exactly remember"};
    String com[]={"light skin","fair skin","olive skin","tan brown","black brown","Don't exactly remember"};
    String alias,box,hair,height,eyes,age,Gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        next=findViewById(R.id.button);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        name=findViewById(R.id.Name);
        rela=findViewById(R.id.Relationship);
        bod=findViewById(R.id.body_type);
        comp=findViewById(R.id.complexion);

        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,rel);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rela.setAdapter(aa);
        rela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter bb=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,bo);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bod.setAdapter(bb);
        bod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter cc=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,com);
        cc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comp.setAdapter(cc);
        comp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Intent fou_next=getIntent();
        alias=fou_next.getStringExtra("alias");
        box=fou_next.getStringExtra("box");
        hair=fou_next.getStringExtra("hair");
        height=fou_next.getStringExtra("height");
        eyes=fou_next.getStringExtra("eyes");
        age=fou_next.getStringExtra("age");
        Gender=fou_next.getStringExtra("Gender");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Phone=phone.getText().toString();
                final String Name=name.getText().toString();
                final String Email=email.getText().toString();
                final String Relation=rela.getSelectedItem().toString();
                final String Body_type=bod.getSelectedItem().toString();
                final String Complexion=comp.getSelectedItem().toString();

                if(TextUtils.isEmpty(Phone))
                {
                    phone.setError("Phone no. is Required");
                }

                else if(TextUtils.isEmpty(Email))
                {
                    email.setError("Email is required");
                }
                else
                {
                    Intent next = new Intent(Main7Activity.this, Main9Activity.class);
                    next.putExtra("alias",alias);
                    next.putExtra("box",box);
                    next.putExtra("hair",hair);
                    next.putExtra("height",height);
                    next.putExtra("eyes",eyes);
                    next.putExtra("age",age);
                    next.putExtra("Gender",Gender);
                    next.putExtra("Phone",Phone);
                    next.putExtra("Email",Email);
                    next.putExtra("Relation",Relation);
                    next.putExtra("Body_type",Body_type);
                    next.putExtra("Complexion",Complexion);
                    next.putExtra("name",Name);

                    startActivity(next);
                }
            }
        });
    }
}
