package com.example.myapplicationmca;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class UNIT2_pro24 extends AppCompatActivity {

     TextView tvSelectedTime;
     Button btnPickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro24);

        tvSelectedTime = findViewById(R.id.tvSelectedTime);
        btnPickTime = findViewById(R.id.btnPickTime);

        btnPickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(UNIT2_pro24.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String timeString = String.format("%02d:%02d", hourOfDay, minute);
                                tvSelectedTime.setText("Time: " + timeString);
                            }
                        }, hour, minute, true);

                timePickerDialog.show();
            }
        });
    }
}