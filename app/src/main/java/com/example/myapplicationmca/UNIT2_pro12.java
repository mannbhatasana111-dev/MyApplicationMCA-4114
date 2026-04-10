package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro12 extends AppCompatActivity {

    private ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro12);

        imgBtn = findViewById(R.id.imgBtn1);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UNIT2_pro12.this, "Marwadi University Selected!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}