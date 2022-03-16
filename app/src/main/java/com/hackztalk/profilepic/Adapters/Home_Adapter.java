package com.hackztalk.profilepic.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hackztalk.profilepic.MainActivity2;
import com.hackztalk.profilepic.Models.Home_Model;
import com.hackztalk.profilepic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.vholder> {

ArrayList<Home_Model> list;
Context context;

    public Home_Adapter(ArrayList<Home_Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public vholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.temp_home,parent,false);

        return new vholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull vholder holder, int position) {

        Home_Model model = list.get(position);

//        holder.frame.setImageResource(model.getFrame());
//        holder.btn.setImageResource(model.getBtn());
        Glide.with(context)
                .load(String.valueOf(list.get(position)))
                .placeholder(model.getFrame())
                .override(150,150)
                .centerCrop()
                .into(holder.frame);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(context, MainActivity2.class);
                i.putExtra("frame",model.getFrame());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class vholder extends RecyclerView.ViewHolder {

        ImageView frame;
        ImageView btn;
    public vholder(@NonNull View itemView) {
        super(itemView);

        frame = itemView.findViewById(R.id.frame);
        btn = itemView.findViewById(R.id.btn);

    }
}

}
