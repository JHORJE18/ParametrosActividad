package com.example.jhorje.parametrosactividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;


public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnviar;
    private EditText txtName;
    private RadioButton rdBtnHom, rdBtnMuj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        txtName = (EditText) findViewById( R.id.txtName );
        rdBtnHom = (RadioButton) findViewById( R.id.radioButton2) ;
        rdBtnMuj = (RadioButton) findViewById( R.id.radioButton) ;

        btnEnviar.setOnClickListener(this);
    }



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

    public void onClick(View v) {

        Log.w("BETA","Has pinchado");
        Intent explicit_intent;//Declaro el Intent

        //Creando Intent
        explicit_intent = new Intent(this,Activity2.class);
        String auxEdiNombre = txtName.getText().toString();
        String auxEdiSexo = "";

        if (rdBtnHom.isChecked()){
            auxEdiSexo = "Hombre";
        } else {
            auxEdiSexo = "Mujer";
        }

        explicit_intent.putExtra("nombre",auxEdiNombre);//Guardamos una cadena
        explicit_intent.putExtra("sexo",auxEdiSexo);//Guardamos un entero

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
    }


}
