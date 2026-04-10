package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.textfield.TextInputEditText;

public class UNIT4_pro49 extends AppCompatActivity {

    private TextInputEditText etPrincipal, etRate, etYears;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_pro49);

        // Link Toolbar to Activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etPrincipal = findViewById(R.id.etPrincipal);
        etRate = findViewById(R.id.etRate);
        etYears = findViewById(R.id.etYears);
        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // IDs must be unique (101, 102, 103)
        menu.add(0, 101, 0, "Simple Interest");
        menu.add(0, 102, 1, "Compound Interest");
        menu.add(0, 103, 2, "Reset Form");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String pStr = etPrincipal.getText().toString();
        String rStr = etRate.getText().toString();
        String tStr = etYears.getText().toString();

        if (item.getItemId() == 103) {
            etPrincipal.setText(""); etRate.setText(""); etYears.setText("");
            tvResult.setText("Tap menu (⋮) to calculate");
            return true;
        }

        if (pStr.isEmpty() || rStr.isEmpty() || tStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        double p = Double.parseDouble(pStr);
        double r = Double.parseDouble(rStr);
        double t = Double.parseDouble(tStr);
        double interest = 0;

        if (item.getItemId() == 101) {
            // SI = (P*R*T)/100
            interest = (p * r * t) / 100;
            tvResult.setText("Simple Interest: ₹" + String.format("%.2f", interest));
        } else if (item.getItemId() == 102) {
            // CI = P(1 + r/100)^t - P
            interest = p * Math.pow((1 + r / 100), t) - p;
            tvResult.setText("Compound Interest: ₹" + String.format("%.2f", interest));
        }
        return true;
    }
}