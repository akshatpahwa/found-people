package com.example.foundpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main9Activity extends AppCompatActivity {
Button nextx;
EditText address,city;
String str2,str3;
Spinner state,expected;
String alias,box,hair,height,price,Gender,eyes,age;
String Phone,Email,Relation,Body_type,Complexion,Name;
String states[]={"Andhra Pradesh","Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand",
        "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab","Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
        "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"};
String expect[]={"Morning","Afternoon","Evening","Night","Don't exactly remember"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        address=findViewById(R.id.address);
        city=findViewById(R.id.city);
        nextx=findViewById(R.id.button2);
        state=findViewById(R.id.state);
        expected=findViewById(R.id.expected);

        Intent next=getIntent();
        alias=next.getStringExtra("alias");
        box=next.getStringExtra("box");
        hair=next.getStringExtra("hair");
        height=next.getStringExtra("height");
        eyes=next.getStringExtra("eyes");
        age=next.getStringExtra("age");
        Gender=next.getStringExtra("Gender");
        Phone=next.getStringExtra("Phone");
        Email=next.getStringExtra("Email");
        Relation=next.getStringExtra("Relation");
        Body_type=next.getStringExtra("Body_type");
        Complexion=next.getStringExtra("Complexion");
        Name=next.getStringExtra("name");



        ArrayAdapter<String> aa=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,states);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(aa);
        ArrayAdapter<String> ab=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,expect);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        expected.setAdapter(ab);
        expected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str2=expected.getSelectedItem().toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str3=state.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        nextx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Address=address.getText().toString();
                final String City=city.getText().toString();
                final String State=state.getSelectedItem().toString();
                final String Expected=expected.getSelectedItem().toString();

                Intent i1=new Intent(Main9Activity.this,Main11Activity.class);
                i1.putExtra("alias",alias);
                i1.putExtra("box",box);
                i1.putExtra("hair",hair);
                i1.putExtra("height",height);
                i1.putExtra("age",age);
                i1.putExtra("eyes",eyes);
                i1.putExtra("Gender",Gender);
                i1.putExtra("Phone",Phone);
                i1.putExtra("Email",Email);
                i1.putExtra("name",Name);
                i1.putExtra("Relation",Relation);
                i1.putExtra("Body_type",Body_type);
                i1.putExtra("Complexion",Complexion);
                i1.putExtra("Address",Address);
                i1.putExtra("City",City);
                i1.putExtra("State",State);
                i1.putExtra("Expected",Expected);


                startActivity(i1);
            }
        });
    }
}
