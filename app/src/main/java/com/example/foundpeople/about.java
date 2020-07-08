package com.example.foundpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class about extends AppCompatActivity {
    EditText editText6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        editText6=findViewById(R.id.editText6);
        editText6.setText("Missing People Find is an initiative to rescue/rehabilitate missing person and share details about them.\n\n" +
                "A team of users that compromises of citizens of a particular jurisdiction along with our application are part of the operation to help trace missing people.\n\n" +
                "This app has been developed with the aim of streamlining the process of finding missing people and to aid organizations that have been working towards the same goal.\n\n" +
                "Currently this app is available in the Google Play store for Android versions 6.0 and above.\n\n");
    }
}
