package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class Extra_Program extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_program);

        // We use a loop to initialize btn_extra1 through btn_extra5
        for (int i = 1; i <= 5; i++) {
            String cardID = "btn_extra" + i;
            int resID = getResources().getIdentifier(cardID, "id", getPackageName());

            MaterialCardView card = findViewById(resID);

            if (card != null) {
                final int index = i;
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        handleNavigation(index);
                    }
                });
            }
        }
    }

    private void handleNavigation(int index) {
        Intent intent = null;

        switch (index) {
            case 1:
                intent = new Intent(Extra_Program.this, E_pro1_1.class);
                break;
            case 2:
                intent = new Intent(Extra_Program.this, E_pro2.class);
                break;
            case 3:
                intent = new Intent(Extra_Program.this, E_pro3.class);
                break;
            case 4:
                intent = new Intent(Extra_Program.this, E_pro4.class);
                break;
            case 5:
                // Program 5 is not made yet
                Toast.makeText(this, "NOT MAKE", Toast.LENGTH_SHORT).show();
                return; // Exit early so startActivity isn't called
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}