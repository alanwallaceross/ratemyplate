package com.example.ratemyplateuploadplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button takePhotoButton;
    private Button choosePhotoButton;
    private Button uploadButton;
    private EditText nameText;
    private EditText captionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takePhotoButton = findViewById(R.id.takePhoto);
        choosePhotoButton = findViewById(R.id.chooseImage);
        uploadButton  = findViewById(R.id.upload);
        nameText = findViewById(R.id.editNameText);
        captionText = findViewById(R.id.editCaptionText);



    }

    private void upload(View view){
        View.OnClickListener uploadListener = new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        };
        uploadButton.setOnClickListener(uploadListener);
    }
}
