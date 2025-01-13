package com.fachrulziyyan.reverie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText loginEmail, loginPassword;
    Button loginButton;
    TextView registerLink; // Tambahkan deklarasi untuk tvRegister

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.etEmail);
        loginPassword = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.btnLogin);
        registerLink = findViewById(R.id.tvRegister); // Hubungkan dengan tvRegister dari XML

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = loginEmail.getText().toString();
                String passwordText = loginPassword.getText().toString();

                if (TextUtils.isEmpty(emailText) || !Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                    Toast.makeText(LoginActivity.this, "Masukkan email yang valid!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passwordText)) {
                    Toast.makeText(LoginActivity.this, "Masukkan password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                String registeredEmail = sharedPreferences.getString("email", "");
                String registeredPassword = sharedPreferences.getString("password", "");

                if (emailText.equals(registeredEmail) && passwordText.equals(registeredPassword)) {
                    Toast.makeText(LoginActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, TabActivity.class)); // Ganti dengan aktivitas tujuan
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Email atau password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Listener untuk teks Register
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke RegisterActivity
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
