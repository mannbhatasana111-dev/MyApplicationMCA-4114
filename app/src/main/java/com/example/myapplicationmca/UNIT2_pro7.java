package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro7 extends AppCompatActivity {

    EditText etUser7, etPass7;
    Button btnVerify7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro7);

        etUser7 = findViewById(R.id.etUser7);
        etPass7 = findViewById(R.id.etPass7);
        btnVerify7 = findViewById(R.id.btnVerify7);

        btnVerify7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUser7.getText().toString();
                String pass = etPass7.getText().toString();

                // Logic: Verification condition
                if (user.equals("test") && pass.equals("1234")) {

                    etUser7.setText("");
                    etPass7.setText("");
                    Intent i = new Intent(UNIT2_pro7.this, UNIT2_pro7_1.class);
                    i.putExtra("u_name", user);
                    i.putExtra("u_pass", pass);
                    startActivity(i);

                } else {
                    Toast.makeText(UNIT2_pro7.this, "Verification Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}