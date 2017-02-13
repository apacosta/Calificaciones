package com.uninorte.calcularnotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;

public class Notas extends AppCompatActivity implements View.OnClickListener{
    Button borrar,siguiente;
    EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        borrar=(Button)findViewById(R.id.borrar1);
        siguiente=(Button)findViewById(R.id.siguiente1);

        nombre=(EditText)findViewById(R.id.nombre);
        borrar.setOnClickListener(this);
        siguiente.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.siguiente1:

                if(nombre.getText().length()==0)    {
                    Toast m=Toast.makeText(this, "Falta Valor", Toast.LENGTH_SHORT);
                    m.show();
                }else{
                    String nom=nombre.getText().toString();
                    Intent i=new Intent(Notas.this, Segunda.class);
                    i.putExtra("nombre",nom);
                    startActivity(i);
                }

                break;

            case R.id.borrar1:

                    nombre.setText("");

                break;




        }
    }
}
