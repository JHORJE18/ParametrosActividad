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
                    mensajeGuay = getString(R.string.txtFlorVida);
                } else {
                    if ( datoEdad >= 18){
                        mensajeGuay = getString(R.string.txtMayorEdad);
                    } else {
                        mensajeGuay = "sal cuanto antes, que no se enteren de que has usado esta app";
                        mensajeGuay = getString(R.string.txtSalYa);
                    }
                }
            } else {
                mensajeGuay = getString(R.string.txtAi);
            }

            txtEdad.setText(getString(R.string.txtTienes) + datoEdad + getString(R.string.txtAños) + mensajeGuay);
            layEdad.setVisibility(View.VISIBLE);
            layDatos.setVisibility(View.GONE);
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

        Intent explicit_intent;//Declaro el Intent

        //Creando Intent
        explicit_intent = new Intent(this,Activity2.class);
        String auxEdiNombre = txtName.getText().toString();
        String auxEdiSexo = "";

        if (rdBtnHom.isChecked()){
            auxEdiSexo = getString(R.string.txtHombre);
        } else if (rdBtnMuj.isChecked()){
            auxEdiSexo = getString(R.string.txtMujer);
        } else {
            auxEdiSexo = getString(R.string.txtOtro);
        }

        explicit_intent.putExtra("nombre",auxEdiNombre);//Guardamos una cadena
        explicit_intent.putExtra("sexo",auxEdiSexo);//Guardamos un entero

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
    }


}
