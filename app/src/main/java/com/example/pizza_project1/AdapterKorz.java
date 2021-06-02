 package com.example.pizza_project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class AdapterKorz extends RecyclerView.Adapter<AdapterKorz.UserViewHolder> {

    private ModelKorz user;

    interface OnUserClickListener{
        void onUserClick(ModelKorz userModel, int position);
        void onUserClickplus(ModelKorz userModel, int position);
        void onUserClickminus(ModelKorz userModel, int position);
    }



    private final List<ModelKorz> list;

    private final LayoutInflater inflater;

    private final AdapterKorz.OnUserClickListener onClickListener;

    private final AdapterKorz.OnUserClickListener onClickListenerplus;

    private final AdapterKorz.OnUserClickListener onClickListenerminus;



    public AdapterKorz(Context context, List<ModelKorz> list, AdapterKorz.OnUserClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.onClickListener = onClickListener;
        this.onClickListenerplus = onClickListener;
        this.onClickListenerminus = onClickListener;
    }

    @Override
    public AdapterKorz.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdapterKorz.UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.res_view, parent, false));
    }



    @Override
    public void onBindViewHolder(AdapterKorz.UserViewHolder holder, int position) {

        ModelKorz user = list.get(position);

        holder.textName.setText(user.frName + " " + user.lastName);
        holder.textAge.setText(user.age + "");
        holder.textJob.setText(user.job);
        holder.kolvo.setText("1");


        Picasso.get().load(user.getImageId()).into(holder.pizzaPhoto);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onUserClick(user, position);

            }
        });
        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListenerplus.onUserClickplus(user, position);
                holder.pizzakol +=1;
                holder.kolvo.setText(holder.pizzakol + "");
            }
        });
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListenerminus.onUserClickminus(user, position);
                holder.pizzakol -=1;
                holder.kolvo.setText(holder.pizzakol + "");
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

        TextView textName, textAge, textJob, kolvo;

        Button button;
        Button button1;
        Button button2;
        int pizzakol = 1;

        ImageView pizzaPhoto;

        public UserViewHolder(View itemView) {
            super(itemView);

            textAge =(TextView) itemView.findViewById(R.id.price);
            textName = (TextView) itemView.findViewById(R.id.name);
            textJob =(TextView)  itemView.findViewById(R.id.opis);
            kolvo =(TextView)  itemView.findViewById(R.id.kolvo);
            pizzaPhoto = (ImageView) itemView.findViewById(R.id.image);
            button = (Button)itemView.findViewById(R.id.delete);
            button1 = (Button)itemView.findViewById(R.id.plus);
            button2 = (Button)itemView.findViewById(R.id.minus);

        }

    }

}

