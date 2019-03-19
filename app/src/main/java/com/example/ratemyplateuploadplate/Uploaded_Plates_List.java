package com.example.ratemyplateuploadplate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Uploaded_Plates_List extends AppCompatActivity {
    // for debugging
    private static final String TAG = "Uploaded_Plates_List";

    // variables


    //passing the data to the adapters
    static private ArrayList<String> imageNames = new ArrayList<>();
    static private ArrayList<String> imageCaptions = new ArrayList<>();
    static private ArrayList<Bitmap> images = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_plates);

//        loadData();

        initRecyclerView();
        initImageBitmaps();

//        saveData();
        // debugging
        Log.d(TAG, "onCreate: started");




//        if (savedInstanceState != null){
//            imageNames = savedInstanceState.getStringArrayList("image_names");
//            imageCaptions = savedInstanceState.getStringArrayList("image_captions");
//            images = savedInstanceState.getParcelableArrayList("images");
//        }


    }

    private void saveData(){
//        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        Gson gson = new Gson();
//        String jsonNames = gson.toJson(imageNames);
//        String jsonCaptions = gson.toJson(imageCaptions);
//        String jsonImages = gson.toJson(images);
//        editor.putString("image_name_list", jsonNames);
//        editor.putString("image_caption_list", jsonCaptions);
//        editor.putString("image_list", jsonImages);
//        editor.apply();
        String fileForNames = "fileForNames";
        File file = new File(this.getFilesDir(), fileForNames);
        FileOutputStream outputStream;
        try{
            outputStream = openFileOutput(fileForNames, Context.MODE_PRIVATE);
            outputStream.write(imageNames.indexOf(0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData(){
//        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
//        Gson gson = new Gson();
//        String jsonNames = sharedPreferences.getString("image_name_list", null);
//        String jsonCaptions = sharedPreferences.getString("image_caption_list", null);
//        String jsonImages = sharedPreferences.getString("image_list", null);
//        Type typeNames = new TypeToken<ArrayList<String>>() {}.getType();
//        Type typeCaptions = new TypeToken<ArrayList<String>>() {}.getType();
//        Type typeImages = new TypeToken<ArrayList<Bitmap>>() {}.getType();
//        imageNames = gson.fromJson(jsonNames, typeNames);
//        imageCaptions = gson.fromJson(jsonCaptions, typeCaptions);
//        images = gson.fromJson(jsonImages, typeImages);
//
//
//        if (imageNames == null || imageCaptions == null || images == null){
//            imageNames = new ArrayList<>();
//            imageCaptions = new ArrayList<>();
//            images = new ArrayList<>();
//        }

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putStringArrayList("image_names", imageNames);
        savedInstanceState.putStringArrayList("image_captions", imageCaptions);
        savedInstanceState.putParcelableArrayList("images", images);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        imageNames = savedInstanceState.getStringArrayList("image_names");
        imageCaptions = savedInstanceState.getStringArrayList("image_captions");
        images = savedInstanceState.getParcelableArrayList("images");
    }

    protected void initImageBitmaps() {
        Log.d(TAG, "initImagesBitmaps: preparing bitmaps");

        //plate images from google
        //Plate name

        imageNames.add(getIntent().getStringExtra("name"));
        imageCaptions.add(getIntent().getStringExtra("caption"));
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        images.add(bitmap);

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init RecyclerView");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageNames, imageCaptions, images, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemClickSupport.addTo(recyclerView)
                .setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {


                        return false;


                    }
                });


    }


}
