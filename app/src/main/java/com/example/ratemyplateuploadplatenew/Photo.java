package com.example.ratemyplateuploadplatenew;

public class Photo {
    private static final String JSON_FILENAME = "filename";

    private String mFileName;

    /** Create a photo representing an existing file on disk */
    public Photo(String filename){
        mFileName = filename;
    }
}
