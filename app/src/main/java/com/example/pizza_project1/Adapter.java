package com.example.pizza_project1;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.UserViewHolder> {

    private Model user;

    interface OnUserClickListener{
        void onUserClick(Model userModel, int position);
    }

    private final List<Model> list;

    private final LayoutInflater inflater;

    private final Adapter.OnUserClickListener onClickListener;



    public Adapter(Context context,List<Model> list, Adapter.OnUserClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.onClickListener = onClickListener;
    }

    @Override
    public Adapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Adapter.UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.res_view, parent, false));
    }



    @Override
    public void onBindViewHolder(Adapter.UserViewHolder holder, int position) {

        Model user = list.get(position);

        holder.textName.setText(user.frName + " " + user.lastName);
        holder.textAge.setText(user.age + "");
        holder.textJob.setText(user.job);

        Picasso.get().load(user.getImageId()).into(holder.pizzaPhoto);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onUserClick(user, position);
            }
        });


//        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
//            @Override
//            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
////                menu.add(holder.getAdapterPosition(), 0, 0,"Удалить");
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textAge, textJob;

        Button button;

        ImageView pizzaPhoto;

        public UserViewHolder(View itemView) {
            super(itemView);

            textAge =(TextView) itemView.findViewById(R.id.price);
            textName = (TextView) itemView.findViewById(R.id.name);
            textJob =(TextView)  itemView.findViewById(R.id.opis);
            pizzaPhoto = (ImageView) itemView.findViewById(R.id.image);
            button = (Button)itemView.findViewById(R.id.delete);

        }

    }

}

