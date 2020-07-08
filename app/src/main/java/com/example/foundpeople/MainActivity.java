package com.example.foundpeople;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button register;
    EditText username,password,email;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;
    TextView already;
    String userId;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        register = findViewById(R.id.submit);
        already=findViewById(R.id.already);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                final String Username = username.getText().toString().trim();
                if(TextUtils.isEmpty(Email))
                {
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    password.setError("Password is required");
                    return;
                }
                if(TextUtils.isEmpty(Username))
                {
                    username.setError("Username is required");
                    return;
                }
                if(password.length()<8)
                {
                    password.setError("Length must be greater than 8 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            //Toast.makeText(getApplicationContext(),"Login is successful",Toast.LENGTH_SHORT);
                            userId = firebaseAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = firestore.collection("users").document(userId);
                            Map<String, Object> user = new HashMap<>();
                            user.put("username", Username);
                            user.put("email", Email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "onSuccess: user Profile is created for "+ username);
                                    Toast.makeText(getApplicationContext(),"Login is successful",Toast.LENGTH_SHORT);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("TAG", "onFailure: " + e.toString());
                                }
                            });

                            startActivity(new Intent(getApplicationContext(),foulos.class));
                            finish();
                        }
                        else {

                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT);
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,registered.class));
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.feedback) {
            Intent feed=new Intent(MainActivity.this,feedback.class);
            startActivity(feed);
        }
        if (id == R.id.Support) {
            Intent suppo=new Intent(MainActivity.this,support.class);
            startActivity(suppo);
        }
        if (id == R.id.Contact_us) {
            Intent oth=new Intent(MainActivity.this,others.class);
            startActivity(oth);
        }
        if (id == R.id.About) {
            Intent abo=new Intent(MainActivity.this,about.class);
            startActivity(abo);
        }
        return super.onOptionsItemSelected(item);
    }
}
