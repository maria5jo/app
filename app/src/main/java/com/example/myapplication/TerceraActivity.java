package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class TerceraActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        tv1 = (TextView) findViewById(R.id.nombre);
        tv2 = (TextView) findViewById(R.id.apellido);
        tv3 = (TextView) findViewById(R.id.cargo);
        tv4 = (TextView) findViewById(R.id.sueldo);
        tv5 = (TextView) findViewById(R.id.dias);
        tv6 = (TextView) findViewById(R.id.valordia);
        tv7 = (TextView) findViewById(R.id.sueldoneto);

        String nombre = getIntent().getStringExtra("nombre");
        String apellido= getIntent().getStringExtra("apellido");
        String cargo = getIntent().getStringExtra("cargo");
        String sueldo = getIntent().getStringExtra("sueldo");
        String dia = getIntent().getStringExtra("dia");
        double valorDia = getIntent().getDoubleExtra("valorDia",0.0);
        tv6.setText(String.valueOf(valorDia));

        double sueldoNeto = getIntent().getDoubleExtra("sueldoNeto", 0.0);
        tv7.setText(String.valueOf(sueldoNeto));


        tv1.setText(nombre);
        tv2.setText(apellido);
        tv3.setText(cargo);
        tv4.setText(sueldo);
        tv5.setText(dia);



    }
}