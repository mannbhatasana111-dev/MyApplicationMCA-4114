package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UNIT2_pro10 extends AppCompatActivity {

    TextView tvExpression, tvResult;
    double val1 = 0, val2 = 0;
    String op = "";
    boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro10);

        tvExpression = findViewById(R.id.tvExpression);
        tvResult = findViewById(R.id.tvResult);

        int[] numbers = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDot};

        for (int id : numbers) {
            findViewById(id).setOnClickListener(v -> {
                Button b = (Button) v;
                if (isNewOp) tvExpression.setText("");
                isNewOp = false;
                tvExpression.append(b.getText().toString());
            });
        }

        int[] operators = {R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv, R.id.btnMod};

        for (int id : operators) {
            findViewById(id).setOnClickListener(v -> {
                val1 = Double.parseDouble(tvExpression.getText().toString());
                op = ((Button) v).getText().toString();
                isNewOp = true;
            });
        }

        findViewById(R.id.btnEqual).setOnClickListener(v -> {
            val2 = Double.parseDouble(tvExpression.getText().toString());
            double res = 0;

            if (op.equals("+")) res = val1 + val2;
            else if (op.equals("-")) res = val1 - val2;
            else if (op.equals("×")) res = val1 * val2;
            else if (op.equals("÷")) res = val1 / val2;
            else if (op.equals("%")) res = val1 % val2;

            tvResult.setText(String.valueOf(res));
            isNewOp = true;
        });

        // --- CLEAR BUTTON ---
        findViewById(R.id.btnClear).setOnClickListener(v -> {
            tvExpression.setText("");
            tvResult.setText("0");
            val1 = 0;
            val2 = 0;
        });
    }
}