package com.larriu.in3model.main.normal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.larriu.in3model.R;
import com.larriu.in3model.authentication.AuthActivity;
import com.larriu.in3model.intro.IntroActivity;

public class MainActivityNormal extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setUp();

        setContentView(R.layout.activity_main);

        // Configure the bottom navigation and the controller for the fragments
        controller = Navigation.findNavController(this, R.id.fragment);
        navigationView = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(navigationView, controller);

    }

    private void setUp() {
        //Checkear si el usuario ha visto la presentacion
        presentation();
    }

    private void presentation() {
        if (!getSharedPreferences("preferences", Context.MODE_PRIVATE).getBoolean("seenIntro", false)){
            Intent intent = new Intent(this, IntroActivity.class);
            startActivity(intent);
            finish();
        } else {
            //Checkear si hay una sesión activa
            session();
        }

    }

    private void session() {
        //Check si hay un usuario autenticado
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String email = preferences.getString("email", null);
        String provider = preferences.getString("provider", null);

        if (email == null && provider == null){
            showAuth();
        }
    }

    private void showAuth() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }

}