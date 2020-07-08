package com.example.foundpeople;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import javax.xml.transform.Result;

public class Main5Activity extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE=1;
    Button Confirm;
    ImageView imageToUpload;
    RadioGroup rg;
    RadioButton Gender;
    String alias,box,hair,height,eyes,age;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    Uri path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Confirm=findViewById(R.id.Confirm);
        rg=findViewById(R.id.rg);
        imageToUpload=findViewById(R.id.imagetoUpload);
       firebaseStorage =FirebaseStorage.getInstance();
       storageReference = firebaseStorage.getReference();
       databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        Intent found_next=getIntent();
        alias=found_next.getStringExtra("alias");
        box=found_next.getStringExtra("box");
        hair=found_next.getStringExtra("hair");
        height=found_next.getStringExtra("height");
        eyes=found_next.getStringExtra("eyes");
        age=found_next.getStringExtra("age");

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Gender=findViewById(rg.getCheckedRadioButtonId());
                    final String gender=Gender.getText().toString();
                    uplodeImage(alias);
                    Intent fou_next=new Intent(Main5Activity.this,Main7Activity.class);
                    fou_next.putExtra("alias",alias);
                    fou_next.putExtra("box",box);
                    fou_next.putExtra("hair",hair);
                    fou_next.putExtra("height",height);
                    fou_next.putExtra("eyes",eyes);
                    fou_next.putExtra("age",age);
                    fou_next.putExtra("Gender",gender);
                    startActivity(fou_next);
            }
        });
        imageToUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.imagetoUpload:
                        Intent galleryIntent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE);
                        break;
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode== RESULT_OK && data!=null){
             path=data.getData();
            imageToUpload.setImageURI(path);

        }
    }

    private void uplodeImage(String name)
    {
            final String text = name;
            if(path!=null)
            {
               storageReference.child("images/"+ UUID.randomUUID().toString()).putFile(path).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                   @Override
                   public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                      Toast.makeText(getApplicationContext(),"Uploded",Toast.LENGTH_SHORT).show();
                      uplode up = new uplode(text,taskSnapshot.toString());
                      String uplodeId = databaseReference.push().getKey();
                      databaseReference.child(uplodeId).setValue(up);
                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                   }
               });



            }

    }
}
