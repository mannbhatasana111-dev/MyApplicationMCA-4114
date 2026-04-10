package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro18 extends AppCompatActivity {

    private ImageView imgView;
    private Button btnChange;
    private boolean isImageOne = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro18);

        imgView = findViewById(R.id.myImageView);
        btnChange = findViewById(R.id.btnChangeImage);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isImageOne) {
                    imgView.setImageResource(R.drawable.marwadi_logo1);
                    isImageOne = false;
                } else {
                    imgView.setImageResource(R.drawable.marwadi_logo3);
                    isImageOne = true;
                }
            }
        });
    }
}