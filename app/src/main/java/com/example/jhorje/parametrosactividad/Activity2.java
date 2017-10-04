package com.example.jhorje.parametrosactividad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView txtPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtPantalla = (TextView) findViewById( R.id.textView );


        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre=(String)extras.get("nombre");//Obtengo el nombre
            String datoSexo= (String) extras.get("sexo");//Obtengo la edad

            txtPantalla.setText("Hola " +  datoNombre + ", eres " + datoSexo);
        }
    }
}
