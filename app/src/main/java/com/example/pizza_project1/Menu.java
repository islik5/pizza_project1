package com.example.pizza_project1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Menu extends Fragment {


    private RecyclerView recyclerView;
    private List<UserModel> result;
    public UserAdapter adapter;

    private FirebaseDatabase database;
    private DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        result = new ArrayList<>();

        recyclerView = view.findViewById(R.id.user_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager lim = new LinearLayoutManager(getActivity());
        lim.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(lim);


        adapter = new UserAdapter(result);
        recyclerView.setAdapter(adapter);

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
//            result.add(new UserModel("name","lastname","job","15","","https://i.stack.imgur.com/mijgV.png"));
//        }
//    }

    private void updateList(){
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                UserModel model = dataSnapshot.getValue(UserModel.class);
                model.setKey(dataSnapshot.getKey());
                result.add(dataSnapshot.getValue(UserModel.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                UserModel model = dataSnapshot.getValue(UserModel.class);
                int index = getItemIndex(model);
                model.setKey(dataSnapshot.getKey());
                result.set(index, model);
                adapter.notifyItemChanged(index);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                UserModel model = dataSnapshot.getValue(UserModel.class);
                model.setKey(dataSnapshot.getKey());
                int index = getItemIndex(model);
                result.remove(index);
                adapter.notifyItemRemoved(index);

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot,String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    private int getItemIndex(UserModel user){
        int index = -1;

        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).key.equals(user.key))
                index = i;
            break;
        }
        return index;
    }


}