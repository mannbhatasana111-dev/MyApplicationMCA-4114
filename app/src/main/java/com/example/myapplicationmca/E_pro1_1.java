package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class E_pro1_1 extends AppCompatActivity {

    EditText etFirstName, etLastName, etMobile, etEmail, etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epro11);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String mobile = etMobile.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || mobile.isEmpty() || email.isEmpty() || password.isEmpty()) {

                    Toast.makeText(E_pro1_1.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(E_pro1_1.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(E_pro1_1.this,E_pro1_2.class);
                    i.putExtra("fn",firstName);
                    i.putExtra("ln",lastName);
                    i.putExtra("mobile",mobile);
                    i.putExtra("email",email);
                    i.putExtra("password",password);
                    startActivity(i);

                }
            }
        });
    }
}
