package com.example.jhorje.parametrosactividad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    TextView txtPantalla;
    private EditText txtEdad;
    private Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtPantalla = (TextView) findViewById( R.id.textView );
        txtEdad = (EditText) findViewById(R.id.editText);
        btnContinuar = (Button) findViewById(R.id.button);

        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre=(String)extras.get("nombre");//Obtengo el nombre
            String datoSexo= (String) extras.get("sexo");//Obtengo la edad

            txtPantalla.setText(getString(R.string.txtHola) +  datoNombre + getString(R.string.txtEres) + datoSexo);

        }

        btnContinuar.setOnClickListener(this);
    }

    //Clic en botón
    public void onClick(View v) {

        Intent explicit_intent;//Declaro el Intent

        //Creando Intent
        explicit_intent = new Intent(this,Activity1.class);
        int auxEditEdad = Integer.parseInt(txtEdad.getText().toString());

        explicit_intent.putExtra("edad",auxEditEdad);//Guardamos la edad

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
    }
}
