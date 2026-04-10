package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro22 extends AppCompatActivity {

    private MultiAutoCompleteTextView multiAutoTextView;
    private String[] skills = {"Java", "JavaScript", "Python", "PHP", "C++", "Kotlin", "Swift", "Android", "SQL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro22);

        multiAutoTextView = findViewById(R.id.multiAutoTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, skills);

        multiAutoTextView.setAdapter(adapter);

        // This allows the user to select multiple items separated by a comma
        multiAutoTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}