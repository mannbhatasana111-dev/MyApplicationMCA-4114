package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UNIT1_pro4 extends AppCompatActivity {

    EditText edtText;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_pro4);

        edtText = findViewById(R.id.edtText);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtText.getText().toString();

                if (text.isEmpty()) {
                    Toast.makeText(UNIT1_pro4.this,
                            "Please enter text",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UNIT1_pro4.this,text,Toast.LENGTH_SHORT).show();
                    edtText.setText("");
                }
            }
        });
    }
}
