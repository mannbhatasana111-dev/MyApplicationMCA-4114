package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro15 extends AppCompatActivity {

    private CheckBox java, python, android;
    private Button btnSubmit;
    private TextView tvResult; // The new TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro15);

        // Initialize components
        java = findViewById(R.id.cbJava);
        python = findViewById(R.id.cbPython);
        android = findViewById(R.id.cbAndroid);
        btnSubmit = findViewById(R.id.btnOrder);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                result.append("You Selected:\n");

                boolean anySelected = false;

                if (java.isChecked()) {
                    result.append("• Java\n");
                    anySelected = true;
                }
                if (python.isChecked()) {
                    result.append("• Python\n");
                    anySelected = true;
                }
                if (android.isChecked()) {
                    result.append("• Android");
                    anySelected = true;
                }

                if (!anySelected) {
                    tvResult.setText("Nothing selected!");
                } else {
                    tvResult.setText(result.toString());
                }
            }
        });
    }
}