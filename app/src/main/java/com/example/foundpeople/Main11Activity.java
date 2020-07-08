package com.example.foundpeople;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Main11Activity extends AppCompatActivity {
    CalendarView calender;
    TextView date_view;
    String str;
    Button btn;
    String alias,box,hair,height,price,Gender,age,eye;
    String Phone,Email,Relation,Body_type,Complexion;
    String Address,city_name,state_name,Expected,Name;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        calender = findViewById(R.id.calender);
        date_view = findViewById(R.id.date_view);
        btn=findViewById(R.id.Confirm);

        Intent i1=getIntent();
        alias=i1.getStringExtra("alias");
        box=i1.getStringExtra("box");
        hair=i1.getStringExtra("hair");
        age=i1.getStringExtra("age");
        eye=i1.getStringExtra("eyes");
        height=i1.getStringExtra("height");
        Gender=i1.getStringExtra("Gender");
        Name=i1.getStringExtra("name");
        Phone=i1.getStringExtra("Phone");
        Email=i1.getStringExtra("Email");
        Relation=i1.getStringExtra("Relation");
        Body_type=i1.getStringExtra("Body_type");
        Complexion=i1.getStringExtra("Complexion");
        Address=i1.getStringExtra("Address");
        city_name=i1.getStringExtra("City");
        state_name=i1.getStringExtra("State");
        Expected=i1.getStringExtra("Expected" );


        db=FirebaseFirestore.getInstance();
        calender.setOnDateChangeListener(new CalendarView
                                .OnDateChangeListener() {
                            @Override
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth) {
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;
                                date_view.setText(Date);
                            }
                        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cal=date_view.getText().toString();
                final Map<String,String> Data=new HashMap<>();

                Data.put("calendar",cal);
                Data.put("Address",Address);
                Data.put("City_name",city_name);
                Data.put("State_name",state_name);
                Data.put("Expected",Expected);
                Data.put("Phone",Phone);
                Data.put("Email",Email);
                Data.put("Alias",alias);
                Data.put("Relation",Relation);
                Data.put("Body",Body_type);
                Data.put("Complexion",Complexion);
                Data.put("Gender",Gender);
                Data.put("name",Name);
                Data.put("Age",age);
                Data.put("Anything",box);
                Data.put("Height",height);
                Data.put("eyes",eye);
                Data.put("Hair",hair);

                db.collection("Found values").add(Data).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(getApplicationContext(),"Data is saved",Toast.LENGTH_SHORT);
                startActivity(new Intent(getApplicationContext(),final_lost.class));
            }
        });
            }
        });
    }
}