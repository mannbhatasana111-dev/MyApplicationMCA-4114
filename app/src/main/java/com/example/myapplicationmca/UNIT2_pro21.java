package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro21 extends AppCompatActivity {

     AutoCompleteTextView autoCompleteTextView;
     String[] languages = {"Java", "JavaScript", "Python", "PHP", "C++", "Kotlin", "Swift"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro21);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, languages);

        autoCompleteTextView.setAdapter(adapter);
    }
}