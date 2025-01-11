package com.fachrulziyyan.reverie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password, rePassword;
    Button registerButton;
    TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        rePassword = findViewById(R.id.re_password);
        registerButton = findViewById(R.id.register_button);
        loginLink = findViewById(R.id.login_link);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                String rePasswordText = rePassword.getText().toString();

                if (emailText.isEmpty() || passwordText.isEmpty() || rePasswordText.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Isi semua kolom!", Toast.LENGTH_SHORT).show();
                } else if (!passwordText.equals(rePasswordText)) {
                    Toast.makeText(RegisterActivity.this, "Password tidak cocok!", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email", emailText);
                    editor.putString("password", passwordText);
                    editor.apply();

                    Toast.makeText(RegisterActivity.this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}
