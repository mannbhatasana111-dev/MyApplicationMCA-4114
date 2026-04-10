package com.example.myapplicationmca;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.textfield.TextInputEditText;

public class UNIT4_pro46 extends AppCompatActivity {

    // UI Components
    private TextInputEditText etName;
    private SwitchCompat switchStatus;
    private Button btnSave, btnLoad;

    // SharedPreferences Constants
    private static final String PREF_NAME = "UserPrefs";
    private static final String KEY_NAME = "user_name";
    private static final String KEY_REMEMBER = "remember_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_pro46);

        // 1. Initialize Views
        etName = findViewById(R.id.etName);
        switchStatus = findViewById(R.id.switchStatus);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);

        // 2. Save Data logic
        btnSave.setOnClickListener(v -> {
            saveData();
        });

        // 3. Load Data logic
        btnLoad.setOnClickListener(v -> {
            loadData();
        });
    }

    private void saveData() {
        // Open SharedPreferences in Private mode (only this app can access it)
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        // Put values into the editor
        editor.putString(KEY_NAME, etName.getText().toString());
        editor.putBoolean(KEY_REMEMBER, switchStatus.isChecked());

        // apply() saves data in the background (asynchronous)
        editor.apply();

        Toast.makeText(this, "Preferences Saved!", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Retrieve values (the second parameter is the default value if key is not found)
        String name = sharedPref.getString(KEY_NAME, "");
        boolean remember = sharedPref.getBoolean(KEY_REMEMBER, false);

        // Update UI with loaded data
        etName.setText(name);
        switchStatus.setChecked(remember);

        Toast.makeText(this, "Preferences Loaded!", Toast.LENGTH_SHORT).show();
    }
}