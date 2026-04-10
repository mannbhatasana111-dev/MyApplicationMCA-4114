package com.example.myapplicationmca;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro8 extends AppCompatActivity {

    EditText etPhoneNumber;
    Button btnMakeCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro8);

        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnMakeCall = findViewById(R.id.btnMakeCall);

        btnMakeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etPhoneNumber.getText().toString();

                if (!number.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);

                    intent.setData(Uri.parse("tel:" + number));

                    startActivity(intent);
                } else {
                    Toast.makeText(UNIT2_pro8.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}