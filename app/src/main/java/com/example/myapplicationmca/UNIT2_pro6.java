package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro6 extends AppCompatActivity {

    EditText etUser, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro6);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();


                if (user.equals("test") && pass.equals("1234")) {

                    Intent i = new Intent(UNIT2_pro6.this, UNIT2_pro6_1.class);
                    i.putExtra("key_user", user);
                    startActivity(i);
                } else {
                    Toast.makeText(UNIT2_pro6.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}