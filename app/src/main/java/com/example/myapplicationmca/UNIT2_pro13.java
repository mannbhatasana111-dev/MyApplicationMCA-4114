package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro13 extends AppCompatActivity {

    ListView listView;
    // Updated data source for Programming Languages
    String[] languages = {"Java", "Kotlin", "Python", "JavaScript", "C#", "C++", "Swift", "Dart", "PHP", "Ruby", "Go", "Rust"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro13);

        // Link the ListView from XML
        listView = findViewById(R.id.listView1);

        // Create the Adapter with the new languages array
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                languages
        );

        // Bind data to the ListView
        listView.setAdapter(adapter);

        // Handle item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang = languages[position];
                Toast.makeText(UNIT2_pro13.this, "Selected Language: " + selectedLang, Toast.LENGTH_SHORT).show();
            }
        });
    }
}