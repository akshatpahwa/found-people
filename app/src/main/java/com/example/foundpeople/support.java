package com.example.foundpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class support extends AppCompatActivity {
EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        edit=findViewById(R.id.editText8);
        edit.setText("1)\tWho can use this app?\n" +
                "Ans- Anyone who wants to upload details about their missing relatives or someone who wants to help in finding missing people.\n\n"+
                "2)Who can see the information?\n" +
                "Ans- Information is crucial so it won’t be shared with anybody\n\n"+
                "3)How do I upload missing person details?\n" +
                "a) log in via otp\n" +
                "b) tap on missing person button.\n" +
                "c) At last, enter available details into the form.\n\n"+
                "4) How do I know if someone’s found?\n" +
                "You can only know if we are able to find someone related to you.\n");
    }
}
