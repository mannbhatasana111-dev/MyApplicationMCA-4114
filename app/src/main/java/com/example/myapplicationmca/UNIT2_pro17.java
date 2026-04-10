package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro17 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button btnSubmit;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro17);

        // Initialize UI components
        radioGroup = findViewById(R.id.paymentGroup);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvSelection);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int checkedId = radioGroup.getCheckedRadioButtonId();

                if (checkedId == -1) {
                    tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                } else {

                    RadioButton selectedBtn = findViewById(checkedId);
                    String choice = selectedBtn.getText().toString();
                    tvResult.setText("Selected: " + choice);
                    tvResult.setTextColor(getResources().getColor(android.R.color.black));
                }
            }
        });
    }
}