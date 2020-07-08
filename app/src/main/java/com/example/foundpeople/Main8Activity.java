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

public class Main8Activity extends AppCompatActivity {
    Button next;
    EditText address,city;
    Spinner state,expected;
    String Name,Age,Anything_else,Height,Eye,Hair,Gender,Phone,Email,Alias,Relation,Body_type,Complexion;
    String states[]={"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand",
            "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab","Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
            "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"};
    String expect[]={"Morning","Afternoon","Evening","Night","Don't exactly remember"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        address=findViewById(R.id.address);
        city=findViewById(R.id.city);
        next=findViewById(R.id.button2);
        state=findViewById(R.id.state);
        expected=findViewById(R.id.expected);

        Intent nextt =getIntent();
        Name=nextt.getExtras().getString("Name");
        Age=nextt.getExtras().getString("Age");
        Anything_else=nextt.getExtras().getString("Anything_else");
        Height=nextt.getExtras().getString("Height");
        Eye=nextt.getExtras().getString("Eyes");
        Hair=nextt.getExtras().getString("Hair");
        Gender=nextt.getExtras().getString("Gender");
        Phone=nextt.getExtras().getString("phone");
        Email=nextt.getExtras().getString("email");
        Alias=nextt.getExtras().getString("alias");
        Relation=nextt.getExtras().getString("Relation");
        Body_type=nextt.getExtras().getString("Body");
        Complexion=nextt.getExtras().getString("Complexion");

        ArrayAdapter<String> aa=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,states);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(aa);
        ArrayAdapter<String> ab=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,expect);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        expected.setAdapter(ab);
        expected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                final String Address=address.getText().toString();
                final String City=city.getText().toString();
                final String Expected=expected.getSelectedItem().toString();
                final String State=state.getSelectedItem().toString();
                if(TextUtils.isEmpty(Address))
                {
                    address.setError("Enter Address");
                }
                else if(TextUtils.isEmpty(City))
                {
                    city.setError("Enter city name");
                }
                Intent i=new Intent(Main8Activity.this,Main10Activity.class);
                i.putExtra("Gender",Gender);
                i.putExtra("Address",Address);
                i.putExtra("City",City);
                i.putExtra("Expected",Expected);
                i.putExtra("State",State);
                i.putExtra("phone",Phone);
                i.putExtra("email",Email);
                i.putExtra("alias",Alias);
                i.putExtra("Relation",Relation);
                i.putExtra("Body",Body_type);
                i.putExtra("Complexion",Complexion);
                i.putExtra("Name",Name);
                i.putExtra("Age",Age);
                i.putExtra("Anything_else",Anything_else);
                i.putExtra("Height",Height);
                i.putExtra("Eyes",Eye);
                i.putExtra("Hair",Hair);
                startActivity(i);
            }
        });
    }
}