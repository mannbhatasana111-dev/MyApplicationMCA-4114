package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT3_pro34 extends AppCompatActivity {

    EditText etName;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_pro34);

        // Initialize views
        etName = findViewById(R.id.et_name);
        btnSubmit = findViewById(R.id.btn_submit);
        tvResult = findViewById(R.id.tv_result);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                if (!name.isEmpty()) {
                    tvResult.setText("Welcome, " + name + "!");
                } else {
                    tvResult.setText("Please enter a name");
                }
            }
        });
    }
}