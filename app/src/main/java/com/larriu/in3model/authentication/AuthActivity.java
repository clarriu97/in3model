package com.larriu.in3model.authentication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.larriu.in3model.R;
import com.larriu.in3model.main.normal.MainActivityNormal;


public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        setTitle("AUTENTICACIÓN");

        ((Button)findViewById(R.id.continueButtonAuthActivity)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("email", "asdf");
                editor.putString("provider", "asdf");
                editor.commit();

                Intent intent = new Intent(AuthActivity.this, MainActivityNormal.class);
                startActivity(intent);
                finish();
            }
        });

    }
}