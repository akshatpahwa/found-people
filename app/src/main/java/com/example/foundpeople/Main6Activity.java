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

import java.util.HashMap;
import java.util.Map;

public class Main6Activity extends AppCompatActivity {
    EditText phone,email,alias;
    Button next;
    Spinner rela,bod,comp;
    String rel[]={"father","mother","brother","sister","uncle","aunt"};
    String bo[]={"mesomorph(Well defined muscles)","ectomorph(Long and lean)","endomorph(Wider body)","Don't exactly remember"};
    String com[]={"light skin","fair skin","olive skin","tan brown","black brown","Don't exactly remember"};
    String Name,Age,Anything_else,Height,Eye,Hair,Gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        next=findViewById(R.id.button);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        alias=findViewById(R.id.Name);
        rela=findViewById(R.id.Relationship);
        bod=findViewById(R.id.body_type);
        comp=findViewById(R.id.complexion);

        Intent los_next=this.getIntent();
        Gender=los_next.getExtras().getString("Gender");
        Name=los_next.getExtras().getString("Name");
        Age=los_next.getExtras().getString("Age");
        Anything_else=los_next.getExtras().getString("Anything_else");
        Height=los_next.getExtras().getString("Height");
        Eye=los_next.getExtras().getString("Eyes");
        Hair=los_next.getExtras().getString("Hair");
        Gender=los_next.getExtras().getString("Gender");


        final Map<String,String> Values=new HashMap<>();
        Values.put("Gender",Gender);

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
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Phone=phone.getText().toString();
                final String Email=email.getText().toString();
                final String Alias=alias.getText().toString();
                final String Relation=rela.getSelectedItem().toString();
                final String Body=bod.getSelectedItem().toString();
                final String Complexion=comp.getSelectedItem().toString();

                if(TextUtils.isEmpty(Phone))
                {
                    phone.setError("Phone no is Required");
                }
                else if(TextUtils.isEmpty(Email))
                {
                    email.setError("Email is mandatory.");
                }
                else if(TextUtils.isEmpty(Alias))
                {
                    alias.setError("Alias is mandatory");
                }
                else
                {
                    Intent nextt = new Intent(Main6Activity.this, Main8Activity.class);
                    nextt.putExtra("Gender",Gender);
                    nextt.putExtra("phone",Phone);
                    nextt.putExtra("email",Email);
                    nextt.putExtra("alias",Alias);
                    nextt.putExtra("Relation",Relation);
                    nextt.putExtra("Body",Body);
                    nextt.putExtra("Complexion",Complexion);
                    nextt.putExtra("Name",Name);
                    nextt.putExtra("Age",Age);
                    nextt.putExtra("Anything_else",Anything_else);
                    nextt.putExtra("Height",Height);
                    nextt.putExtra("Eyes",Eye);
                    nextt.putExtra("Hair",Hair);




                    startActivity(nextt);
                }
            }
        });
    }
}
