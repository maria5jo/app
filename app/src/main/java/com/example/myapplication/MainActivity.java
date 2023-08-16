package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adaptadores.ListaContactosAdapter;
import com.example.myapplication.db.DbContactos;
import com.example.myapplication.db.DbHelper;
import com.example.myapplication.entidades.Contactos;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button btnCrear;
    Toolbar toolbar1;
    RecyclerView listaContactos;
    ArrayList<Contactos> listarArrayContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);




       listaContactos = findViewById(R.id.listarContactos);
       listaContactos.setLayoutManager(new LinearLayoutManager(this));
        DbContactos dbContactos = new DbContactos(MainActivity.this);

        listarArrayContactos = new ArrayList<>();
        ListaContactosAdapter adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);
        /*btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this,"ERROR AL CREAR LA BASE DE DATOS ",Toast.LENGTH_LONG).show();
                }

            }
        });

         */
    }
  public void siguiente(View view){
      Intent siguente = new Intent(this, SegundaActivity.class);
      startActivity(siguente);
  }

  public void Agenda(View view){
        Intent Agenda = new Intent(this, agendaActivity.class);
  }
   public boolean onCreateOptionsMenu(Menu menu){
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.menu_principal,menu);
       return true;
   }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()== R.id.menuNuevo){
            nuevoRegistro();
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevaActivity.class);
        startActivity(intent);
    }

}