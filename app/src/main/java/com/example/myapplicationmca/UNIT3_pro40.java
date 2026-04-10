package com.example.myapplicationmca;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class UNIT3_pro40 extends AppCompatActivity {

    TextInputEditText etPhone, etMessage;
    MaterialButton btnSend;

    private static final int SMS_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_unit3_pro40);

        etPhone = findViewById(R.id.etPhone);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        // Request SMS Permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    SMS_PERMISSION_CODE);
        }

        btnSend.setOnClickListener(v -> {

            String phone = etPhone.getText().toString().trim();
            String message = etMessage.getText().toString().trim();

            if (phone.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Please enter phone and message", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone, null, message, null, null);
                Toast.makeText(this, "SMS Sent Successfully!", Toast.LENGTH_SHORT).show();
                etPhone.setText("");
                etMessage.setText("");
                etPhone.requestFocus();
            } catch (Exception e) {
                Toast.makeText(this, "SMS Failed!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }
}