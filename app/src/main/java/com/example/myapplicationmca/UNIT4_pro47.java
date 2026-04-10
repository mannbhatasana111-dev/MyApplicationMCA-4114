package com.example.myapplicationmca;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UNIT4_pro47 extends AppCompatActivity {

    private TextInputEditText etUserData;
    private Button btnSave, btnRead;

    private static final String FILE_NAME = "my_private_notes.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_pro47);

        // 1. Initialize the UI components
        etUserData = findViewById(R.id.etUserData);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);

        // 2. Set Click Listener for Saving
        btnSave.setOnClickListener(v -> {
            String data = etUserData.getText().toString();
            if (!data.isEmpty()) {
                saveDataInternal(data);
            } else {
                Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. Set Click Listener for Reading
        btnRead.setOnClickListener(v -> {
            String data = readDataInternal();
            if (data != null) {
                etUserData.setText(data);
                Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveDataInternal(String data) {
        try {
            // openFileOutput creates or opens a file in private mode
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            osw.write(data);
            osw.flush();
            osw.close();

            etUserData.setText(""); // Clear field after saving
            Toast.makeText(this, "Saved to Internal Storage!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String readDataInternal() {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);

            char[] inputBuffer = new char[100];
            StringBuilder sb = new StringBuilder();
            int charRead;

            // Read the file content into the StringBuilder
            while ((charRead = isr.read(inputBuffer)) > 0) {
                sb.append(String.copyValueOf(inputBuffer, 0, charRead));
            }

            isr.close();
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "File not found or empty", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}