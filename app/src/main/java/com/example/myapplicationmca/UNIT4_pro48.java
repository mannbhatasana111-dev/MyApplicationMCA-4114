package com.example.myapplicationmca;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UNIT4_pro48 extends AppCompatActivity {

    private TextInputEditText etExternalData;
    private Button btnSaveExt, btnReadExt;
    private String fileName = "ExternalData.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_pro48);

        etExternalData = findViewById(R.id.etExternalData);
        btnSaveExt = findViewById(R.id.btnSaveExt);
        btnReadExt = findViewById(R.id.btnReadExt);

        btnSaveExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToExternal();
            }
        });

        btnReadExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDataFromExternal();
            }
        });
    }

    private void saveDataToExternal() {
        String state = Environment.getExternalStorageState();

        // Check if the external storage is mounted and writable
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            try {
                // Accessing the app-specific external directory
                File folder = getExternalFilesDir("MyExternalNotes");
                File myFile = new File(folder, fileName);

                FileOutputStream fos = new FileOutputStream(myFile);
                OutputStreamWriter osw = new OutputStreamWriter(fos);

                osw.write(etExternalData.getText().toString());
                osw.flush();
                osw.close();
                fos.close();

                etExternalData.setText("");
                Toast.makeText(this, "Saved to External Storage", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "SD Card not found or not writable", Toast.LENGTH_SHORT).show();
        }
    }

    private void readDataFromExternal() {
        try {
            File folder = getExternalFilesDir("MyExternalNotes");
            File myFile = new File(folder, fileName);

            if (myFile.exists()) {
                FileInputStream fis = new FileInputStream(myFile);
                InputStreamReader isr = new InputStreamReader(fis);

                char[] buffer = new char[100];
                StringBuilder sb = new StringBuilder();
                int charRead;

                while ((charRead = isr.read(buffer)) > 0) {
                    sb.append(String.copyValueOf(buffer, 0, charRead));
                }

                isr.close();
                fis.close();

                etExternalData.setText(sb.toString());
                Toast.makeText(this, "Data Read Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No file found on external storage", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Read Error", Toast.LENGTH_SHORT).show();
        }
    }
}