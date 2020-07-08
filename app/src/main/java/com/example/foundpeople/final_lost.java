package com.example.foundpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;

public class final_lost extends AppCompatActivity {
    TextView box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_lost);
        box=findViewById(R.id.box);
        box.setText("Thank you for having belief in us. Hope for the best!! If we find something we will inform you.");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),foulos.class));
            }
        },3000);
    }
}
