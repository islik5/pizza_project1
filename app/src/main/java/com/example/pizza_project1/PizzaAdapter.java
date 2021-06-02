package com.example.pizza_project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.UserViewHolder>{
    interface OnUserClickListener{
        void onUserClick(PizzaModel userModel, int position);
    }

    private final List<PizzaModel> list;

    private final LayoutInflater inflater;

    private final OnUserClickListener onClickListener;



    public PizzaAdapter(Context context, List<PizzaModel> list, OnUserClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.onClickListener = onClickListener;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        PizzaModel user = list.get(position);

        holder.textName.setText(user.firstName + " " + user.lastName);
        holder.textAge.setText(user.age + "");
        holder.textJob.setText(user.job);

        Picasso.get().load(user.getImageId()).into(holder.pizzaPhoto);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onUserClick(user, position);
            }
        });



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

            textAge =(TextView) itemView.findViewById(R.id.text_price);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            textJob =(TextView)  itemView.findViewById(R.id.text_opis);
            pizzaPhoto = (ImageView) itemView.findViewById(R.id.image_pizza);
            button = (Button)itemView.findViewById(R.id.vkorzina);

        }

    }

}
