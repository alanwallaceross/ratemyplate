package com.example.ratemyplateuploadplate;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    // delcaration
    private ArrayList<String> imageNames = new ArrayList<>();
    private ArrayList<String> imageCaptions = new ArrayList<>();
    private ArrayList<Bitmap> images = new ArrayList<>();

    private Context context;


    // constructor
    public RecyclerViewAdapter(ArrayList<String> imageNames, ArrayList<String> imageCaptions, ArrayList<Bitmap> images, Context context) {
        this.imageNames = imageNames;
        this.imageCaptions = imageCaptions;
        this.images = images;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plate_list_element, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // log for debugging
        Log.d(TAG,"onBindViewHolder: called.");

        //gets the images, converts to bitmap, loads into holder


        holder.imageName.setText(imageNames.get(position));

        holder.imageCaption.setText(imageCaptions.get(position));

        holder.image.setImageBitmap(images.get(position));

        // user clicks on list in the list
//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: clicked on:" + imageNames.get(position));
//
//                Toast.makeText(context, imageNames.get(position), Toast.LENGTH_SHORT).show();
//
//                //takes user to the item in the list they clicked on
//                Intent intent = new Intent(context, Plate_item.class);
//                intent.putExtra("image", images.get(position));
//                intent.putExtra("image_name", imageNames.get(position));
//                intent.putExtra("image_caption", imageCaptions.get(position));
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {

        // return the list, without this, blank screen
        return imageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView imageName;
        TextView imageCaption;
        CircleImageView image;
        RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            imageCaption = itemView.findViewById(R.id.image_caption);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}