package com.example.foundpeople;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
private static final int RESULT_LOAD_IMAGE=1;
Button Confirm;
ImageView imageToUpload;
RadioGroup rg;
RadioButton gender;
String Name,Age,Anything_else,Height,Eye,Hair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Confirm=findViewById(R.id.Confirm);
        rg=findViewById(R.id.rg);
        imageToUpload=findViewById(R.id.imagetoUpload);

        Intent lost_next=this.getIntent();
        Name=lost_next.getExtras().getString("Name");
        Age=lost_next.getExtras().getString("Age");
        Anything_else=lost_next.getExtras().getString("Anything_else");
        Height=lost_next.getExtras().getString("Height");
        Eye=lost_next.getExtras().getString("Eyes");
        Hair=lost_next.getExtras().getString("Hair");


        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender=findViewById(rg.getCheckedRadioButtonId());
                final String Gender=gender.getText().toString();
                Intent los_next=new Intent(Main4Activity.this,Main6Activity.class);
                los_next.putExtra("Gender",Gender);
                los_next.putExtra("Name",Name);
                los_next.putExtra("Age",Age);
                los_next.putExtra("Anything_else",Anything_else);
                los_next.putExtra("Height",Height);
                los_next.putExtra("Eyes",Eye);
                los_next.putExtra("Hair",Hair);
                startActivity(los_next);
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
            Uri selectedImage=data.getData();
            imageToUpload.setImageURI(selectedImage);
        }
    }
}
