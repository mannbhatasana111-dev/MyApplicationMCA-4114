package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class UNIT3_pro31 extends AppCompatActivity {

    MaterialButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro31);

        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UNIT3_pro31.this, "Profile Saved Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}