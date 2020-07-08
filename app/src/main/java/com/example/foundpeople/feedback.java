package com.example.foundpeople;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class feedback extends AppCompatActivity {
    EditText e1;
    Button save;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        e1=findViewById(R.id.editText6);
        save=findViewById(R.id.save);
        db=FirebaseFirestore.getInstance();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fee=e1.getText().toString();
                final Map<String,String> feedback=new HashMap<>();
                feedback.put("feed",fee);
                db.collection("feedback").add(feedback).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(feedback.this, "Thanks for your support", Toast.LENGTH_SHORT).show();
                        e1.setText("");
                        Intent i=new Intent(feedback.this,MainActivity.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}
