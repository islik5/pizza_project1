package com.example.pizza_project1;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Timer;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private final List<UserModel> list;
    private Context parent;
    private Intent intent;



    public UserAdapter(List<UserModel> list) {
        this.list = list;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, int position) {

        UserModel user = list.get(position);

        holder.textName.setText(user.firstName + " " + user.lastName);
        holder.textAge.setText(user.age + "");
        holder.textJob.setText(user.job);

        Picasso.get().load(user.getImageId()).into(holder.pizzaPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(holder.getAdapterPosition(), 0, 0,"Удалить");

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textAge, textJob;

        ImageView pizzaPhoto;

        public UserViewHolder(View itemView) {
            super(itemView);

            textAge =(TextView) itemView.findViewById(R.id.text_price);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            textJob =(TextView)  itemView.findViewById(R.id.text_opis);
            pizzaPhoto = (ImageView) itemView.findViewById(R.id.image_pizza);

//            pizzaPhoto.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    intent = new Intent(parent, Timer.class);
//                    parent.startActivity(intent);
//                }
//            });

        }

    }

}
