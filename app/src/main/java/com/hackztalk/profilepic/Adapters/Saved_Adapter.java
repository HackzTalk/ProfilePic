package com.hackztalk.profilepic.Adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackztalk.profilepic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Saved_Adapter extends RecyclerView.Adapter<Saved_Adapter.vholder>{

    ArrayList<Uri> list;

    public Saved_Adapter(ArrayList<Uri> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public vholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.temp_saved,parent,false);

        return new vholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull vholder holder, int position) {

        Picasso.get()
                .load(list.get(position))
                .resize(180,180)
                .centerCrop()
                .into(holder.savedimg);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class vholder extends RecyclerView.ViewHolder {

        ImageView savedimg;
        public vholder(@NonNull View itemView) {
            super(itemView);

            savedimg = itemView.findViewById(R.id.savedimg);

        }
    }
}
