package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.db.DbContactos;

public class NuevaActivity extends AppCompatActivity {
    EditText txtNombre, txtTelefono, txtCorreo;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);
        txtNombre = findViewById(R.id.textNombre);
        txtTelefono = findViewById(R.id.textTelefono);
        txtCorreo =  findViewById(R.id.textCorreo);
        btnGuardar = findViewById(R.id.botnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(NuevaActivity.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(),txtTelefono.getText().toString(),txtCorreo.getText().toString());
                if (id > 0){
                    Toast.makeText(NuevaActivity.this, "REGISTRO AGREGADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    Toast.makeText(NuevaActivity.this, "ERROR AL GUARDAR REGSITRO", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");

    }

}