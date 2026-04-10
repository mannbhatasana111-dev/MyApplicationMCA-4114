package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class E_pro2 extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    RadioGroup radioGroup;
    RadioButton male, female;
    CheckBox c1, c2, c3, c4;
    TextView resultPrint, txtResult;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epro2);

        listView = findViewById(R.id.list);
        spinner = findViewById(R.id.spin);
        radioGroup = findViewById(R.id.radgrp);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        resultPrint = findViewById(R.id.resultprint);
        btn1 = findViewById(R.id.btnsubmitepro2);
        txtResult = findViewById(R.id.txtresult);

        String[] city = {"RAJKOT", "GONDAL", "CHOTILA", "JUNAGADH", "MORBI", "SURAT", "SOMNATH", "PORBANDAR"};
        ArrayAdapter<String> arr = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, city);
        listView.setAdapter(arr);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(E_pro2.this, "USER SELECT CITY : " + city[i], Toast.LENGTH_SHORT).show();
            }
        });

        String[] country = {"India", "USA", "UK", "Canada"};
        ArrayAdapter<String> arr_con = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, country);
        spinner.setAdapter(arr_con);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                String con = spinner.getSelectedItem().toString().trim();
                Toast.makeText(E_pro2.this, "USER SELECTED COUNTRY : " + con, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String gender = "";
                if (male.isChecked()) {
                    gender = male.getText().toString().trim();
                }
                if (female.isChecked()) {
                    gender = female.getText().toString().trim();
                }
                resultPrint.setText("USER SELECTED GENDER : " + gender);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vehicle = "";

                if (c1.isChecked()) {
                    vehicle += c1.getText().toString().trim() + " , ";
                }
                if (c2.isChecked()) {
                    vehicle += c2.getText().toString().trim() + " , ";
                }
                if (c3.isChecked()) {
                    vehicle += c3.getText().toString().trim() + " , ";
                }
                if (c4.isChecked()) {
                    vehicle += c4.getText().toString().trim() + " , ";
                }
                if (!vehicle.isEmpty()) {
                    vehicle = vehicle.substring(0, vehicle.length() - 2);
                }

                txtResult.setText("Vehicle : " + vehicle);
            }
        });


    }
}