package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro16 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button btnSubmit;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro16);

        // Binding variables to UI components
        radioGroup = findViewById(R.id.rgLanguages);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    // Nothing was selected
                    tvResult.setText("Please select a language!");
                    tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                } else {
                    RadioButton selectedButton = findViewById(selectedId);

                    String language = selectedButton.getText().toString();
                    tvResult.setText("Preferred Language: " + language);
                    tvResult.setTextColor(getResources().getColor(android.R.color.black));

                    Toast.makeText(UNIT2_pro16.this, "Saved: " + language, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}