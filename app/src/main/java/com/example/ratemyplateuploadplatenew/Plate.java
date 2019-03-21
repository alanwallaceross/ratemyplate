package com.example.ratemyplateuploadplatenew;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

public class Plate {

    private static final String JSON_NAME = "name";
    private static final String JSON_CAPTION = "caption";
    private static final String JSON_IMAGE = "image";



    private String name;
    private String caption;
    private Bitmap image;

    public Plate(String name, String caption, Bitmap image){
        this.name = name;
        this.caption = caption;
        this.image = image;
    }

    public Plate(JSONObject json) throws JSONException {
        name = json.getString(JSON_NAME);
        caption = json.getString(JSON_CAPTION);
        Gson gson = new Gson();
        image = gson.newJsonReader()
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_NAME, name);
        json.put(JSON_CAPTION, caption);
        json.put(JSON_IMAGE, image);
        return json;
    }

    private String getStringFromBitmap(Bitmap bitmapPicture) {
        final int COMPRESSION_QUALITY = 100;
        String encodedImage;
        ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.PNG, COMPRESSION_QUALITY,
                byteArrayBitmapStream);
        byte[] b = byteArrayBitmapStream.toByteArray();
        encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encodedImage;
    }

    private Bitmap getBitmapFromString(String stringPicture) {
        byte[] decodedString = Base64.decode(stringPicture, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
