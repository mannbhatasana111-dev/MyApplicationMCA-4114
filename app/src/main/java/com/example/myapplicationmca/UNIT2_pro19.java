package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro19 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro19);

        final TextView displayTitle = findViewById(R.id.displayTitle);
        final EditText userInput = findViewById(R.id.userInput);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // Button action
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userInput.getText().toString().trim();

                if (!name.isEmpty()) {
                    displayTitle.setText("Hello, " + name + "!");
                    userInput.setText("");

                } else {
                    userInput.setError("Please enter a name");
                }
            }
        });
    }
}