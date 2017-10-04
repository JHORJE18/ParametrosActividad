package com.example.jhorje.parametrosactividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnviar;
    private EditText txtName;
    private RadioButton rdBtnHom, rdBtnMuj;
    private TextView txtEdad;
    private LinearLayout layDatos, layEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //Asociar elementos Vista <-> Controlador
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        txtName = (EditText) findViewById( R.id.txtName );
        rdBtnHom = (RadioButton) findViewById( R.id.radioButton2) ;
        rdBtnMuj = (RadioButton) findViewById( R.id.radioButton) ;
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        layDatos = (LinearLayout) findViewById( R.id.linearDatos) ;
        layEdad = (LinearLayout) findViewById( R.id.linearEdad) ;

        //Obtener valores pantalla 2
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {//ver si contiene datos
            int datoEdad = (int) extras.get("edad");//Obtengo la edad

            String mensajeGuay = "";
            if (datoEdad < 35){
                if (datoEdad >= 25){
                    mensajeGuay = "estas en la flor de la vida";
                } else {
                    if ( datoEdad >= 18){
                        mensajeGuay = "ja eres major d'edat";
                    } else {
                        mensajeGuay = "sal cuanto antes, que no se enteren de que has usado esta app";
                    }
                }
            } else {
                mensajeGuay = "ai, ai, ai...";
            }

            txtEdad.setText("Tienes unos " + datoEdad + " años, " + mensajeGuay);
            layEdad.setVisibility(View.VISIBLE);
            layDatos.setVisibility(View.INVISIBLE);
        } else {
            //No se ha recibido datos
            layEdad.setVisibility(View.GONE);
        }

        btnEnviar.setOnClickListener(this);
    }


    //Comprobador radiobuttons checkeados
    public void onRadioButtonClicked(View view) {

        //Boton pulsado?
        boolean checked = ((RadioButton) view).isChecked();

        //Boton presionado
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    break;
            case R.id.radioButton2:
                if (checked)
                    break;
        }
    }

    //Clic en botón
    public void onClick(View v) {

        Log.w("BETA","Has pinchado");
        Intent explicit_intent;//Declaro el Intent

        //Creando Intent
        explicit_intent = new Intent(this,Activity2.class);
        String auxEdiNombre = txtName.getText().toString();
        String auxEdiSexo = "";

        if (rdBtnHom.isChecked()){
            auxEdiSexo = "Hombre";
        } else if (rdBtnMuj.isChecked()){
            auxEdiSexo = "Mujer";
        } else {
            auxEdiSexo = "un misterio";
        }

        explicit_intent.putExtra("nombre",auxEdiNombre);//Guardamos una cadena
        explicit_intent.putExtra("sexo",auxEdiSexo);//Guardamos un entero

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
    }


}
