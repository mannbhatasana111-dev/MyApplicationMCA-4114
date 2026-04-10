package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UNIT4_pro44 extends AppCompatActivity {

    Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_pro44);

        btnShowDialog = findViewById(R.id.btnShowDialog);

        btnShowDialog.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(UNIT4_pro44.this);

            builder.setTitle("Delete Confirmation");
            builder.setMessage("Are you sure you want to delete this item?");
            builder.setCancelable(false);

            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(UNIT4_pro44.this,
                            "Item Deleted Successfully",
                            Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(UNIT4_pro44.this,
                            "Operation Cancelled",
                            Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }
}