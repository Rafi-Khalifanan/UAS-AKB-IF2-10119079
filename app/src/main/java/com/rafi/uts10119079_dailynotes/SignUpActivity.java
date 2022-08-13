package com.rafi.uts10119079_dailynotes;
//13 Agustus 2022, 10119079, Rafi Khalifanan Azanan, IF2
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.rafi.uts10119079_dailynotes.main.profile.ProfileActivity;
import android.os.Bundle;

public class SignUpActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnMasuk, btnDaftar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();

        btnMasuk = (Button) findViewById(R.id.sign_in_button);
        btnDaftar = (Button) findViewById(R.id.sign_up_button);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);

        btnMasuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUpActivity.this, "User dan Email berhasil dibuat" , Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this, ProfileActivity.class));
                        finish();

                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Otentikasi Gagal!" + task.getException(), Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            finish();
                        }
                    }
                });
            }
        });

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
    }
}