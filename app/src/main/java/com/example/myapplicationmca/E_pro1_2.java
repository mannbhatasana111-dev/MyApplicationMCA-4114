package com.example.myapplicationmca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class E_pro1_2 extends AppCompatActivity {

    TextView firstname,lastname,tmobile,temail,tpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epro12);
        firstname = findViewById(R.id.FirstName);
        lastname = findViewById(R.id.LastName);
        tmobile = findViewById(R.id.Mobile);
        temail = findViewById(R.id.Email);
        tpassword = findViewById(R.id.Password);

        Intent i ;
        String firstName = getIntent().getStringExtra("fn");
        String lastName =  getIntent().getStringExtra("ln");
        String mobile = getIntent().getStringExtra("mobile");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");

        firstname.setText("FIRST NAME  : "+firstName.toUpperCase());
        lastname.setText("LAST NAME   : "+lastName.toUpperCase());
        tmobile.setText("MOBILE       : "+mobile);
        temail.setText("EMAIL        : "+email);
        tpassword.setText("PASSWORD    : "+password);

    }
}