package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class UNIT3_pro30 extends AppCompatActivity {

    ImageView imgTarget;
    MaterialButton btnFade, btnRotate, btnZoom, btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro30);

        imgTarget = findViewById(R.id.imgTarget);
        btnFade = findViewById(R.id.btnFade);
        btnRotate = findViewById(R.id.btnRotate);
        btnZoom = findViewById(R.id.btnZoom);
        btnMove = findViewById(R.id.btnMove);

        btnFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                imgTarget.startAnimation(anim);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                imgTarget.startAnimation(anim);
            }
        });

        // You can also create simple animations directly in Java
        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTarget.animate().scaleX(1.5f).scaleY(1.5f).setDuration(500).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        imgTarget.animate().scaleX(1f).scaleY(1f).setDuration(500);
                    }
                });
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTarget.animate().translationX(200f).setDuration(500).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        imgTarget.animate().translationX(0f).setDuration(500);
                    }
                });
            }
        });
    }
}