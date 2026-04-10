package com.example.myapplicationmca;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class UNIT2_pro23 extends AppCompatActivity {

     TextView tvSelectedDate;
     Button btnPickDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro23);

        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        btnPickDate = findViewById(R.id.btnPickDate);

        btnPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(UNIT2_pro23.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                tvSelectedDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);

                datePickerDialog.show();
            }
        });
    }
}