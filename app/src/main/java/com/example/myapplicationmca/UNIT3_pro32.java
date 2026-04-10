package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class UNIT3_pro32 extends AppCompatActivity {

    TextInputEditText etName, etEmail;
    MaterialButton btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro32);

        etName = findViewById(R.id.et_firstname);
        etEmail = findViewById(R.id.et_email);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();

                if (name.isEmpty()) {
                    etName.setError("Name is required!");
                } else {
                    Toast.makeText(UNIT3_pro32.this, "Registration Successful for " + name, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}