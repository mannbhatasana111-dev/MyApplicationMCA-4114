package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class UNIT2_LIST_PAGE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_list_page);

        // We use a loop to initialize all cards from 6 to 28
        // This replaces writing 'findViewById' and 'setOnClickListener' 23 times!
        for (int i = 6; i <= 28; i++) {
            String buttonID = "btn_pro" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());

            MaterialCardView card = findViewById(resID);

            if (card != null) {
                final int programNum = i;
                card.setOnClickListener(v -> openProgram(programNum));
            }
        }
    }

    /**
     * Helper method to handle navigation logic
     * @param number The program number clicked
     */
    private void openProgram(int number) {
        Intent intent = null;

        // Routing logic
        switch (number) {
            case 6:
                intent = new Intent(this, UNIT2_pro6.class);
                break;
            case 7:
                intent = new Intent(this, UNIT2_pro7.class);
                break;
            case 8:
                intent = new Intent(this, UNIT2_pro8.class);
                break;
            case 9:
                intent = new Intent(this, UNIT2_pro9.class);
                break;
            case 10:
                intent = new Intent(this, UNIT2_pro10.class);
                break;
            case 11:
                intent = new Intent(this, UNIT2_pro11.class);
                break;
            case 12:
                intent = new Intent(this, UNIT2_pro12.class);
                break;
            case 13:
                intent = new Intent(this, UNIT2_pro13.class);
                break;
            case 14:
                intent = new Intent(this, UNIT2_pro14.class);
                break;
            case 15:
                intent = new Intent(this, UNIT2_pro15.class);
                break;
            case 16:
                intent = new Intent(this, UNIT2_pro16.class);
                break;
            case 17:
                intent = new Intent(this, UNIT2_pro17.class);
                break;
            case 18:
                intent = new Intent(this, UNIT2_pro18.class);
                break;
            case 19:
                intent = new Intent(this, UNIT2_pro19.class);
                break;
            case 20:
                intent = new Intent(this, UNIT2_pro20.class);
                break;
            case 21:
                intent = new Intent(this, UNIT2_pro21.class);
                break;
            case 22:
                intent = new Intent(this, UNIT2_pro22.class);
                break;
            case 23:
                intent = new Intent(this, UNIT2_pro23.class);
                break;
            case 24:
                intent = new Intent(this, UNIT2_pro24.class);
                break;
            case 25:
                intent = new Intent(this, UNIT2_pro25.class);
                break;
            case 26:
                intent = new Intent(this, UNIT2_pro26.class);
                break;
            case 27:
                intent = new Intent(this, UNIT2_pro27.class);
                break;
            case 28:
                intent = new Intent(this, UNIT2_pro28.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Program " + number + " Activity not found!", Toast.LENGTH_SHORT).show();
        }
    }
}