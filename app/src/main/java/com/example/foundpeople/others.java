package com.example.foundpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class others extends AppCompatActivity {
    Button save;
    EditText box;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        box=findViewById(R.id.box);
        box.setText("Our team Contact no:-7688888568\n"+"Mail address:-Akshatpahwa8@gmail.com");
    }
}
