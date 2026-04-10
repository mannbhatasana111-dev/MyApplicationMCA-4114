package com.example.myapplicationmca;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class E_pro3 extends AppCompatActivity {

    AutoCompleteTextView autocomplete;
    MultiAutoCompleteTextView multiautocomplete;
    Button btnSubmit;
    TextView txtResult;
    RatingBar rate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epro3);

        autocomplete = findViewById(R.id.autoComplete);
        multiautocomplete = findViewById(R.id.multiauto);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);
        rate = findViewById(R.id.rate);


        String[] university = {
                "MARWADI UNIVERSITY",
                "ATMIYA UNIVERSITY",
                "RK UNIVERSITY",
                "GUJARAT UNIVERSITY",
                "MAHARAJA SAYAJIRAO UNIVERSITY OF BARODA",
                "SARDAR PATEL UNIVERSITY",
                "SAURASHTRA UNIVERSITY",
                "HEMCHANDRACHARYA NORTH GUJARAT UNIVERSITY",
                "VEER NARMAD SOUTH GUJARAT UNIVERSITY",
                "KADI SARVA VISHWAVIDYALAYA",
                "GUJARAT TECHNOLOGICAL UNIVERSITY",
                "GUJARAT NATIONAL LAW UNIVERSITY",
                "RASHTRIYA RAKSHA UNIVERSITY",
                "CENTRAL UNIVERSITY OF GUJARAT",
                "PANDIT DEENDAYAL ENERGY UNIVERSITY",
                "NIRMA UNIVERSITY",
                "PARUL UNIVERSITY",
                "CHAROTAR UNIVERSITY OF SCIENCE AND TECHNOLOGY",
                "ANAND AGRICULTURAL UNIVERSITY",
                "JUNAGADH AGRICULTURAL UNIVERSITY",
                "NAVSARI AGRICULTURAL UNIVERSITY",
                "SARDARKRUSHINAGAR DANTIWADA AGRICULTURAL UNIVERSITY",
                "KAMDHENU UNIVERSITY",
                "GUJARAT AYURVED UNIVERSITY",
                "GUJARAT VIDYAPITH",
                "CEPT UNIVERSITY",
                "AHMEDABAD UNIVERSITY",
                "UKA TARSADIA UNIVERSITY",
                "DHIRUBHAI AMBANI INSTITUTE OF INFORMATION AND COMMUNICATION TECHNOLOGY",
                "BHAKTA KAVI NARSINH MEHTA UNIVERSITY"
        };

        ArrayAdapter<String> arrayUniversity =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, university);
        autocomplete.setAdapter(arrayUniversity);
        autocomplete.setThreshold(1);

        String[] department = {
                "FACULTY OF COMPUTER APPLICATION",
                "FACULTY OF ENGINEERING",
                "FACULTY OF TECHNOLOGY",
                "FACULTY OF SCIENCE",
                "FACULTY OF ARTS",
                "FACULTY OF COMMERCE",
                "FACULTY OF MANAGEMENT STUDIES",
                "FACULTY OF BUSINESS ADMINISTRATION",
                "FACULTY OF LAW",
                "FACULTY OF EDUCATION",
                "FACULTY OF PHARMACY",
                "FACULTY OF MEDICAL SCIENCE",
                "FACULTY OF DENTAL SCIENCE",
                "FACULTY OF NURSING",
                "FACULTY OF AGRICULTURE",
                "FACULTY OF VETERINARY SCIENCE",
                "FACULTY OF AYURVEDA",
                "FACULTY OF HOME SCIENCE",
                "FACULTY OF SOCIAL SCIENCES",
                "FACULTY OF HUMANITIES",
                "FACULTY OF DESIGN",
                "FACULTY OF ARCHITECTURE",
                "FACULTY OF FINE ARTS",
                "FACULTY OF PERFORMING ARTS",
                "FACULTY OF MASS COMMUNICATION",
                "FACULTY OF JOURNALISM",
                "FACULTY OF HOTEL MANAGEMENT",
                "FACULTY OF TOURISM STUDIES",
                "FACULTY OF PHYSICAL EDUCATION",
                "FACULTY OF ENVIRONMENTAL STUDIES"
        };

        ArrayAdapter<String> arrayDepartment =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, department);
        multiautocomplete.setAdapter(arrayDepartment);
        multiautocomplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiautocomplete.setThreshold(1);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uni = autocomplete.getText().toString().trim();
                String dept = multiautocomplete.getText().toString().trim();
                float rating = rate.getRating();

                if (uni.isEmpty() || dept.isEmpty()) {
                    txtResult.setText("Please select University and Department");
                } else {
                    txtResult.setText("Selected University:\n" + uni + "\n\nSelected Department(s):\n" + dept + "\n\nRating: " + rating + " / 5 ⭐");
                }

            }
        });

    }
}
