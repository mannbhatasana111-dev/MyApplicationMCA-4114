package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class UNIT3_LIST_PAGE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_list_page);

        // We handle programs 29 through 43 in a loop to keep code clean
        for (int i = 29; i <= 43; i++) {
            // Find the ID dynamically (matches btn_pro29, btn_pro30, etc.)
            String cardID = "btn_pro" + i;
            int resID = getResources().getIdentifier(cardID, "id", getPackageName());

            MaterialCardView card = findViewById(resID);

            if (card != null) {
                final int programNumber = i;
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navigateToProgram(programNumber);
                    }
                });
            }
        }
    }

    /**
     * Helper method to handle intent navigation
     * This keeps the onCreate method very clean.
     */
    private void navigateToProgram(int num) {
        Intent intent = null;

        switch (num) {
            case 29: intent = new Intent(this, UNIT3_pro29.class); break;
            case 30: intent = new Intent(this, UNIT3_pro30.class); break;
            case 31: intent = new Intent(this, UNIT3_pro31.class); break;
            case 32: intent = new Intent(this, UNIT3_pro32.class); break;
            case 33: intent = new Intent(this, UNIT3_pro33.class); break;
            case 34: intent = new Intent(this, UNIT3_pro34.class); break;
            case 35: intent = new Intent(this, UNIT3_pro35.class); break;
            case 36: intent = new Intent(this, UNIT3_pro36.class); break;
            case 37: intent = new Intent(this, UNIT3_pro37.class); break;
            case 38: intent = new Intent(this, UNIT3_pro38.class); break;
            case 39: intent = new Intent(this, UNIT3_pro39.class); break;
            case 40: intent = new Intent(this, UNIT3_pro40.class); break;
            case 41: intent = new Intent(this, UNIT3_pro41.class); break;
            case 42: intent = new Intent(this, UNIT3_pro42.class); break;
            case 43: intent = new Intent(this, UNIT3_pro43.class); break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}