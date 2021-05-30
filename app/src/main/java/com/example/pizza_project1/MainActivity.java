package com.example.pizza_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Menu.OnFragmentSendDataListener{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Fragment fr_menu;
    Fragment fr_kontakt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fr_kontakt = new kontakt();
        fr_menu = new Menu();
    }

    public void click(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()){
            case R.id.menu:
                fragmentTransaction.replace(R.id.fragmentContainerView, fr_menu);
                break;
            case R.id.kontakt:
                fragmentTransaction.replace(R.id.fragmentContainerView, fr_kontakt);
                break;
            case R.id.korzina:
                fragmentTransaction.replace(R.id.fragmentContainerView, fr_menu);
                break;
            case R.id.vkorzina:
                fragmentTransaction.replace(R.id.fragmentContainerView, fr_kontakt);
                break;
        }



        fragmentTransaction.commit();
    }

    @Override
    public void onSendData(Button button) {
        click(button);
    }
}