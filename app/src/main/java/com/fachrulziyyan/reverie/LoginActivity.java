package com.fachrulziyyan.reverie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText loginEmail, loginPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                String registeredEmail = sharedPreferences.getString("email", "");
                String registeredPassword = sharedPreferences.getString("password", "");

                String emailText = loginEmail.getText().toString();
                String passwordText = loginPassword.getText().toString();

                if (emailText.equals(registeredEmail) && passwordText.equals(registeredPassword)) {
                    Toast.makeText(LoginActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                    // Lanjutkan ke aktivitas berikutnya
                } else {
                    Toast.makeText(LoginActivity.this, "Email atau password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
