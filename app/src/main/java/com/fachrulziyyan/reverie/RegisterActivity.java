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

public class RegisterActivity extends AppCompatActivity {
    EditText name, email, password, rePassword;
    Button registerButton;
    TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmailRegister);
        password = findViewById(R.id.etPasswordRegister);
        rePassword = findViewById(R.id.etConfirmPassword);
        registerButton = findViewById(R.id.btnRegister);
        loginLink = findViewById(R.id.tvLogin);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                String rePasswordText = rePassword.getText().toString();

                if (TextUtils.isEmpty(nameText)) {
                    Toast.makeText(RegisterActivity.this, "Masukkan nama lengkap!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(emailText) || !Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                    Toast.makeText(RegisterActivity.this, "Masukkan email yang valid!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passwordText.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Password minimal 6 karakter!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!passwordText.equals(rePasswordText)) {
                    Toast.makeText(RegisterActivity.this, "Password tidak cocok!", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", nameText); // Simpan nama pengguna
                editor.putString("email", emailText);
                editor.putString("password", passwordText); // Gunakan enkripsi jika memungkinkan
                editor.apply();

                Toast.makeText(RegisterActivity.this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
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
