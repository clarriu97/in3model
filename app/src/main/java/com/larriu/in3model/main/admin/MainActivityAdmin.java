package com.larriu.in3model.main.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.larriu.in3model.R;
import com.larriu.in3model.Storage;

public class MainActivityAdmin extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //It checks if the user was in the normal app or in the admin app
        if (!checkNormalApp()){
            Intent intent = new Intent(this, MainActivityAdmin.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_main_admin);

        // Configure the bottom navigation and the controller for the fragments
        controller = Navigation.findNavController(this, R.id.fragment2);
        navigationView = findViewById(R.id.bottomNavigationView2);
        NavigationUI.setupWithNavController(navigationView, controller);

    }

    private boolean checkNormalApp(){
        return Storage.get().getUser().isNormalApp();
    }

}