package com.example.touristhelp;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImagesRecycleview extends RecyclerView.Adapter<ImagesRecycleview.ViewHolder> {
private Context context ;
private ArrayList<Images> images;


    public ImagesRecycleview() {
    }

    public ImagesRecycleview(Context c, ArrayList<Images> images){
        this.context=c;

       this.images=images;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_pop_up,parent,false);
        //parent is the parent layout for out layout place_pop-up
       ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int imageRes = images.get(position).getImageName();
        holder.image.setImageResource(imageRes);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogImage dialog = new DialogImage(holder.image.getContext(),imageRes);
                dialog.show();
            }
        });

    }
    public void setImages(ArrayList<Images> img){
        this.images = img;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       private ImageView image ;
        public ViewHolder (View itemView){
            super(itemView);
           image = itemView.findViewById(R.id.scrollImage);
        }

   }
}
