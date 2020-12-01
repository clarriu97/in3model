package com.larriu.in3model.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.larriu.in3model.R;
import com.larriu.in3model.main.normal.MainActivityNormal;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        findViewById(R.id.buttonSignin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkCorrectPassword()){



                } else {
                    Toast.makeText(SigninActivity.this, "Las contraseñas tienen que ser iguales", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.continueButtonSignin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("email", "asdf");
                editor.putString("provider", "asdf");
                editor.commit();

                Intent intent = new Intent(SigninActivity.this, MainActivityNormal.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private boolean checkCorrectPassword() {
        String password = ((TextView)findViewById(R.id.passwordEditTextSignIn)).getText().toString();
        String repeatPassword = ((TextView)findViewById(R.id.repeatPasswordEditTextSignIn)).getText().toString();
        return password.equals(repeatPassword);
    }
}