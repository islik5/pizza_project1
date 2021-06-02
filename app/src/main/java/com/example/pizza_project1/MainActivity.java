package com.example.pizza_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Fragment fr_menu;
    Fragment fr_kontakt;
    Fragment fr_korz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fr_kontakt = new kontakt();
        fr_menu = new Menu();
        fr_korz = new Korzina();
    }

    public void click(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.menu:
                fragmentTransaction.replace(R.id.fragmentContainerView, fr_menu);
                break;
            case R.id.kontakt:
                fragmentTransaction.replace(R.id.fragmentContainerView, fr_kontakt);
                break;
            case R.id.korzina:
                fragmentTransaction.replace(R.id.fragmentContainerView, fr_korz);
                break;
            case R.id.vkorzina:
                fragmentTransaction.replace(R.id.fragmentContainerView, fr_korz);
                break;
        }


        fragmentTransaction.commit();
    }

    public void delete(ModelKorz modelKorz, FirebaseDatabase database) {
        DatabaseReference reference = database.getReference("Korz");

        reference.child(modelKorz.lastName).removeValue();
    }

}