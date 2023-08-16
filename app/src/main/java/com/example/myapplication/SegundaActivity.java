package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SegundaActivity extends AppCompatActivity {
      EditText et1, et2, et3, et4, et5;


      Button btnliquidar;
       CheckBox pension, descuento, salud;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        et1 = (EditText) findViewById(R.id.editTextText3);
        et2 = (EditText) findViewById(R.id.editTextText2);
        et3 = (EditText) findViewById(R.id.editTextText);
        et4 = (EditText) findViewById(R.id.editTextNumber);
        et5 = (EditText) findViewById(R.id.editTextNumber2);
        btnliquidar = (Button) findViewById(R.id.button3);
        pension = (CheckBox) findViewById(R.id.pension);
        descuento = (CheckBox) findViewById(R.id.descuento);
        salud = (CheckBox) findViewById(R.id.salud);



    }


        public void onClick(View view){

        double sueldoInicial = Double.parseDouble(et4.getText().toString());

        boolean checkDescuento = descuento.isChecked();
        boolean checkPension = pension.isChecked();
        boolean checkSalud = salud.isChecked();

        double contador = 0;

            if (checkDescuento){
                contador +=3;
            }
            if(checkPension){
                contador +=4;
            }
            if (checkSalud){
                contador +=4;
            }
            double descuentos = sueldoInicial * (contador / 100);
            double  diasT = Double.parseDouble(et5.getText().toString());
            double valorDia = sueldoInicial / 30 ;
            double salarioBruto = diasT * valorDia;
            double sueldoNeto = salarioBruto - descuentos;


            Intent envioDatos= new Intent (SegundaActivity.this, TerceraActivity.class);

            envioDatos.putExtra("nombre",et1.getText().toString() );
            envioDatos.putExtra("apellido",et2.getText().toString() );
            envioDatos.putExtra("cargo",et3.getText().toString() );
            envioDatos.putExtra("sueldo",et4.getText().toString() );
            envioDatos.putExtra("dia",et5.getText().toString() );
            envioDatos.putExtra("sueldoNeto", sueldoNeto);
            envioDatos.putExtra("valorDia",valorDia);

            startActivity(envioDatos);





        }

    public void Anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }



}