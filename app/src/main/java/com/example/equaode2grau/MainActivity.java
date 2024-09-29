package com.example.equaode2grau;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etA;
    private EditText etB;
    private EditText etC;
    private Button btnCalc;
    private TextView tvRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        etC = findViewById(R.id.etC);
        btnCalc = findViewById(R.id.btnCalc);
        tvRes = findViewById(R.id.tvRes);

        etA.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etB.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        btnCalc.setOnClickListener(op -> Calc());

    }


    public void Calc (){

        double a = Double.parseDouble(etA.getText().toString());
        double b = Double.parseDouble(etB.getText().toString());
        double c = Double.parseDouble(etC.getText().toString());

        if (a == 0){
            String r = "Não é uma equação de 2º Grau ";
            tvRes.setText(r);
        }else {
            double delta = (b * b) - (4 * a * c);

            if (delta < 0) {
                String r = "Equação não possui raízes reais";
                tvRes.setText(r);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                String r = "Delta = " + delta + " | x1 = " + x1 + " e x2 = " + x2;
                tvRes.setText(r);
            }
        }

    }


}