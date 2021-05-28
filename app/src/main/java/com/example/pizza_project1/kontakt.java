package com.example.pizza_project1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class kontakt extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kontakt, container, false);


        Button button1 = (Button) rootView.findViewById(R.id.button);

        button1.setOnClickListener(this);


        return  rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:
                Toast.makeText(getActivity(), "НА НАС НЕЛЬЗЯ ЖАЛОВАТЬСЯ",
                        Toast.LENGTH_SHORT).show();
                break;
        }

    }

}