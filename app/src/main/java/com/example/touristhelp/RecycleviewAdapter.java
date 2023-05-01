package com.example.touristhelp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;


public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.ViewHolder> implements Serializable {
    private ArrayList<PlaceModel> places = new ArrayList<>();
    private Context context ;
    private ArrayList<PlaceModel> placesList;
    private ArrayList<GuideModel>gGuidesList;

    public RecycleviewAdapter(Context c,ArrayList<PlaceModel> placesList) {
        this.context = c ;
        this.placesList = placesList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchpopunp,parent,false);
        //parent is the parent layout for out layout searchpopup
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           holder.placename.setText(places.get(position).getName());
           holder.placecountry.setText(places.get(position).getCountry());
          holder.placecategory.setText(places.get(position).getCategory());
holder.img.setImageResource(places.get(position).getImagUrl() );
         // Picasso.get().load(places.get(position).getImagUrl()).into(holder.img);

        holder.parent.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent in = new Intent(v.getContext(),PlaceView.class);
                   in.putExtra("Place_model", (Serializable) (places.get(holder.getAdapterPosition())));
                   v.getContext().startActivity(in);
                //   Toast.makeText(context,places.get(holder.getAdapterPosition()).getProvence(),Toast.LENGTH_SHORT).show();

               }
           });

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public void setPlaces (ArrayList<PlaceModel> places) {
        this.places = places;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView placename ;
        private TextView placecountry ;
        private TextView placecategory ;
        private ImageView img ;

        private CardView parent;
        public ViewHolder (View itemView){
            super(itemView);
            placename = itemView.findViewById(R.id.placename);
          placecountry = itemView.findViewById(R.id.placecountry);
            placecategory = itemView.findViewById(R.id.placeCategory);
         img = itemView.findViewById(R.id.imgplace);
           parent = itemView.findViewById(R.id.parent);
        }


    }


}
