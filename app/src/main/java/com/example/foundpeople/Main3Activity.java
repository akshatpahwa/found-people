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

public class Main3Activity extends AppCompatActivity {
    EditText lname,lage,lheight,l_box;
    Button lnext;
    Spinner leye,lhair;
    String leye_ar[]={"Black","Brown","Blue","Grey","Don't exactly remember"};
    String lhair_ar[]={"Black","Brown","Grey","Golden","Don't exactly remember"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        l_box=findViewById(R.id.l_box);
        lname=findViewById(R.id.lname);
        lage=findViewById(R.id.lage);
        lheight=findViewById(R.id.lheight);
        lnext=findViewById(R.id.lnext);
        leye=findViewById(R.id.leye_colour_s);
        lhair=findViewById(R.id.lhair_colour_s);

        ArrayAdapter<String> ley=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,leye_ar);
        ArrayAdapter<String> lha=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,lhair_ar);
        leye.setAdapter(ley);
        leye.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        lhair.setAdapter(lha);
        lhair.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Hair=lhair.getSelectedItem().toString();
                final String Name=lname.getText().toString();
                final String Age=lage.getText().toString();
                final String Anything_else=l_box.getText().toString();
                final String Height=lheight.getText().toString();
                final String Eye=leye.getSelectedItem().toString();
                if(TextUtils.isEmpty(Name))
                {
                    lname.setError("Name is Required");
                }
                else if(TextUtils.isEmpty(Age))
                {
                    lage.setError("Age is required");
                }
                else if(TextUtils.isEmpty(Anything_else))
                {
                    l_box.setError("Enter none, if you don't want to mention anything.");
                }
                else if(TextUtils.isEmpty(Height))
                {
                    lheight.setError("Enter Height");
                }
                else {
                    Intent lost_next = new Intent(Main3Activity.this, Main4Activity.class);
                    lost_next.putExtra("Name",Name);
                    lost_next.putExtra("Age",Age);
                    lost_next.putExtra("Anything_else",Anything_else);
                    lost_next.putExtra("Height",Height);
                    lost_next.putExtra("Eyes",Eye);
                    lost_next.putExtra("Hair",Hair);
                    startActivity(lost_next);
                }

            }
        });
        }
}