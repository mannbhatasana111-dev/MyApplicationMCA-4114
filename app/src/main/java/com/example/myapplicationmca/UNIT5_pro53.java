package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class UNIT5_pro53 extends AppCompatActivity {

    private TextView tvName, tvEmail, tvCity;
    private Button btnParse;

    // A slightly more complex JSON to demonstrate real-world nesting
    private final String jsonString = "{"
            + " \"status\": \"success\","
            + " \"data\": {"
            + "     \"user_profile\": {"
            + "         \"full_name\": \"Gemini AI Explorer\","
            + "         \"contact_email\": \"dev.support@google.com\","
            + "         \"meta_data\": {"
            + "             \"location_city\": \"Mountain View, CA\""
            + "         }"
            + "     }"
            + " }"
            + "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit5_pro53);

        // Initialize UI components from the refined XML
        tvName = findViewById(R.id.tvUserName);
        tvEmail = findViewById(R.id.tvUserEmail);
        tvCity = findViewById(R.id.tvUserCity);
        btnParse = findViewById(R.id.btnParse);

        btnParse.setOnClickListener(v -> {
            // Add a subtle click feedback animation
            v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).withEndAction(() -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100).start();
                executeJsonParsing();
            }).start();
        });
    }

    private void executeJsonParsing() {
        try {
            //

            // 1. Convert raw string to root object
            JSONObject root = new JSONObject(jsonString);

            // 2. Check status from JSON before proceeding (Pro Practice)
            String status = root.getString("status");
            if (!status.equals("success")) {
                Toast.makeText(this, "API Error", Toast.LENGTH_SHORT).show();
                return;
            }

            // 3. Drill down through the nested layers
            // Path: data -> user_profile
            JSONObject dataObj = root.getJSONObject("data");
            JSONObject profile = dataObj.getJSONObject("user_profile");

            String name = profile.getString("full_name");
            String email = profile.getString("contact_email");

            // Path: user_profile -> meta_data -> location_city
            JSONObject meta = profile.getJSONObject("meta_data");
            String city = meta.getString("location_city");

            // 4. Update UI with a Fade-In Effect
            updateUiWithAnimation(name, email, city);

            Toast.makeText(this, "Data Synchronized", Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Parsing failed: Check JSON structure", Toast.LENGTH_LONG).show();
        }
    }

    private void updateUiWithAnimation(String name, String email, String city) {
        // Reset Alpha for animation
        tvName.setAlpha(0f);
        tvEmail.setAlpha(0f);
        tvCity.setAlpha(0f);

        // Set Text
        tvName.setText(name);
        tvEmail.setText(email);
        tvCity.setText(city);

        // Animate visibility
        tvName.animate().alpha(1f).translationY(-10).setDuration(400).start();
        tvEmail.animate().alpha(1f).setDuration(600).start();
        tvCity.animate().alpha(1f).setDuration(600).start();
    }
}