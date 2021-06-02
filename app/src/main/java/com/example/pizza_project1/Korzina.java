package com.example.pizza_project1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class Korzina extends Fragment{

    private Button button;

    private TextView textView;
    private TextView textView1;
    private  Button button1;
    private Button button2;


    private RecyclerView recyclerView;
    private List<ModelKorz> result;
    public AdapterKorz adap;

    private FirebaseDatabase database;
    private DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_korzina, container, false);
        button = (Button) view.findViewById(R.id.zakaz);
        textView1 = (TextView) view.findViewById(R.id.kolvo);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Korz");

        result = new ArrayList<>();

        recyclerView = view.findViewById(R.id.user_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager lim = new LinearLayoutManager(getActivity());
        lim.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(lim);

        FirebaseDatabase database = FirebaseDatabase.getInstance();



        adap = new AdapterKorz(getActivity(),result, new AdapterKorz.OnUserClickListener() {
            @Override
            public void onUserClick(ModelKorz modelKorz, int position) {

                if (getActivity() != null) { MainActivity ma = (MainActivity ) getActivity(); ma.delete(modelKorz, database); }

            }

            @Override
            public void onUserClickplus(ModelKorz userModel, int position) {
                Toast.makeText(getActivity(), "Плюс",
                        Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onUserClickminus(ModelKorz userModel, int position) {
                Toast.makeText(getActivity(), "Минус",
                        Toast.LENGTH_SHORT).show();

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Пицца заказана",
                        Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adap);

        updateList();
//        createResult();


        return view;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 0:
                break;
            case 1:
                break;

        }

        return super.onContextItemSelected(item);
    }

//    private void createResult(){
//
//        for (int i = 0; i < 12; i++) {
//            result.add(new Model("name","lastname","job","15","","https://i.stack.imgur.com/mijgV.png"));
//        }
//    }

    private void updateList(){
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                result.add(dataSnapshot.getValue(ModelKorz.class));
                adap.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                ModelKorz model = dataSnapshot.getValue(ModelKorz.class);
                int index = getItemIndex(model);

                result.set(index, model);
                adap.notifyItemChanged(index);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                ModelKorz model = dataSnapshot.getValue(ModelKorz.class);
                int index = getItemIndex(model);

                result.remove(index);
                adap.notifyItemRemoved(index);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot,String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    private int getItemIndex(ModelKorz user){
        int index = -1;

        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).key.equals(user.key))
                index = i;
            break;
        }
        return index;
    }


}