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

public class Main10Activity extends AppCompatActivity {
    CalendarView calender;
    TextView date_view;
    String Name,Age,Anything_else,height,eye,hair,Gender,phone,email,alias,relation,body_type,complexion;
    String Address,city_name,state_name,Expected_time;
    Button confirm;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        calender = findViewById(R.id.calender);
        date_view = findViewById(R.id.date_view);
        confirm=findViewById(R.id.Confirm);

        Intent i=this.getIntent();
        Name=i.getExtras().getString("Name");
        Age=i.getExtras().getString("Age");
        Anything_else=i.getExtras().getString("Anything_else");
        height=i.getExtras().getString("Height");
        eye=i.getExtras().getString("Eyes");
        hair=i.getExtras().getString("Hair");
        Gender=i.getStringExtra("Gender");
        phone=i.getExtras().getString("phone");
        email=i.getExtras().getString("email");
        alias=i.getExtras().getString("alias");
        relation=i.getExtras().getString("Relation");
        body_type=i.getExtras().getString("Body");
        complexion=i.getExtras().getString("Complexion");
        Address=i.getStringExtra("Address");
        city_name=i.getExtras().getString("City");
        state_name=i.getExtras().getString("State");
        Expected_time=i.getExtras().getString("Expected");

        db=FirebaseFirestore.getInstance();
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
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
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cal=date_view.getText().toString();
                final Map<String,String> Values=new HashMap<>();

                Values.put("calendar",cal);
                Values.put("Address",Address);
                Values.put("City_name",city_name);
                Values.put("State_name",state_name);
                Values.put("Time",Expected_time);
                Values.put("phone",phone);
                Values.put("email",email);
                Values.put("alias",alias);
                Values.put("Relation",relation);
                Values.put("Body",body_type);
                Values.put("Complexion",complexion);
                Values.put("Gender",Gender);
                Values.put("Name",Name);
                Values.put("Age",Age);
                Values.put("Anything",Anything_else);
                Values.put("Height",height);
                Values.put("Eyes",eye);
                Values.put("Hair",hair);

                db.collection("Lost values").add(Values).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(getApplicationContext(),"All data is saved",Toast.LENGTH_SHORT);
                        startActivity(new Intent(getApplicationContext(),final_found.class));
                    }
                });
            }
        });
    }
}