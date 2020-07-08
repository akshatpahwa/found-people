package com.example.foundpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class foulos extends AppCompatActivity {
    Button found_b,lost_b;
    TextView logout,founded,contact;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foulos);
        found_b=findViewById(R.id.button4);
        lost_b=findViewById(R.id.button6);
        logout=findViewById(R.id.logout);
        founded=findViewById(R.id.founded);
        contact=findViewById(R.id.contact);
        firebaseAuth = FirebaseAuth.getInstance();
        found_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_found=new Intent(foulos.this,Main2Activity.class);
                startActivity(intent_found);
            }
        });
        lost_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_lost=new Intent(foulos.this,Main3Activity.class);
                startActivity(intent_lost);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(getApplicationContext(),registered.class));
            }
        });
        founded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagesActivity();
                //Intent data=new Intent(foulos.this,datastore.class);
                //startActivity(data);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact=new Intent(foulos.this,others.class);
                startActivity(contact);
            }
        });

    }
    private void openImagesActivity()
    {
        Intent data=new Intent(foulos.this,datastore.class);
        startActivity(data);
    }
}
