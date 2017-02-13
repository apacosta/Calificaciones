package com.uninorte.calcularnotas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Segunda extends AppCompatActivity implements View.OnClickListener {
    Button borrar, siguiente, atras;
    EditText not1, not2, not3, not4;
    String nombre = "";
    Toast m;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);
        borrar = (Button) findViewById(R.id.borrar2);
        siguiente = (Button) findViewById(R.id.siguiente2);
        atras = (Button) findViewById(R.id.atras1);

        not1 = (EditText) findViewById(R.id.nota11);
        not2 = (EditText) findViewById(R.id.nota21);
        not3 = (EditText) findViewById(R.id.nota31);


        atras.setOnClickListener(this);
        borrar.setOnClickListener(this);
        siguiente.setOnClickListener(this);

        Bundle i = getIntent().getExtras();
        nombre = i.getString("nombre");

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.siguiente2:

                if (not1.getText().length() == 0 || not2.getText().length() == 0 || not3.getText().length() == 0) {
                    m = Toast.makeText(this, "Falta Valor", Toast.LENGTH_SHORT);
                    m.show();
                } else {

                    double n1 = Double.parseDouble(not1.getText().toString());
                    double n2 = Double.parseDouble(not2.getText().toString());
                    double n3 = Double.parseDouble(not3.getText().toString());

                    if(n1<0 || n1>5 || n2<0 || n2>5 || n3<0 || n3>5) {
                        m = Toast.makeText(this, "Calificacion Incorrecta, imposible de calcular.", Toast.LENGTH_SHORT);
                        m.show();
                    }else{
                        double promedio = (3.5 - (n1*0.25+n2*0.25+n3*0.25))/0.25;

                        Intent i = new Intent(Segunda.this, Final.class);
                        i.putExtra("nombre", nombre);
                        i.putExtra("promedio",promedio);

                        startActivity(i);
                    }

                }

                break;

            case R.id.borrar2:


                not1.setText("");
                not2.setText("");
                not3.setText("");

                break;

            case R.id.atras1:

                Intent i = new Intent(Segunda.this, Notas.class);
                startActivity(i);

                break;


        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Segunda Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
