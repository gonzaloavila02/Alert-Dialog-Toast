package com.example.a26_actividad1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Switch cambiarColor;
    ConstraintLayout fondo;
    Button boton1, boton_resultado;
    EditText numAleatorio;
    TextView mostrarNumero, text_resultado;
    RadioButton BotonSi,botonNo;
    int numeroAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cambiarColor = (Switch) findViewById(R.id.switch2);
        fondo = (ConstraintLayout) findViewById(R.id.fondo);
        boton1 = (Button) findViewById(R.id.button1);
        mostrarNumero = (TextView) findViewById(R.id.mostrarNum);
        boton_resultado = (Button) findViewById(R.id.boton_Resultado);
        text_resultado = (TextView) findViewById(R.id.text_resultado);
        BotonSi = findViewById(R.id.BotonSi);
        botonNo = findViewById(R.id.botonNo);
        Context context = this;
        int duration = Toast.LENGTH_SHORT;


        cambiarColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cambiarColor.isChecked()){
                    fondo.setBackgroundColor(Color.parseColor("#E3F909"));
                }else{
                    fondo.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                }
            }
        });
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroAleatorio = (int) (Math.random()*(2500-1900)+1 + 1900);

                mostrarNumero.setText(String.valueOf(numeroAleatorio));
            }
        });

        boton_resultado.setOnClickListener(new View.OnClickListener() {
            Toast toast;
            @Override
            public void onClick(View view) {
                String recibo_Cadena =mostrarNumero.getText().toString();
                if (recibo_Cadena.isEmpty()){
                    String text = "Debes generar un número";
                    toast = Toast.makeText(context,text,duration);
                    /* Con el setGravity podemos cambiar la posición en la que nos aparece el toast
                    toast.setGravity(Gravity.CENTER,0,0);
                    */
                    toast.show();
                }else{
                    int numeroMostrado = Integer.parseInt(recibo_Cadena);
                    if (numeroMostrado % 4 == 0 && (numeroMostrado % 100 != 0 || numeroMostrado % 400 == 0)){
                        if(BotonSi.isChecked()){
                            text_resultado.setTextColor(Color.parseColor("#03FF07"));
                            text_resultado.setText("Correcto");
                        }else{
                            if(botonNo.isChecked()){
                                text_resultado.setTextColor(Color.parseColor("#FA0000"));
                                text_resultado.setText("Incorrecto, es bisiesto");
                            }else {
                                text_resultado.setTextColor(Color.parseColor("#FF3700B3"));
                                String text2 = "Debes marcar alguna de las dos opciones";
                                Toast toast  = Toast.makeText(context,text2,duration);
                                toast.show();

                            }
                        }

                    }else{
                        if(botonNo.isChecked()){
                            text_resultado.setTextColor(Color.parseColor("#03FF07"));
                            text_resultado.setText("Correcto");
                        }else{
                            if(BotonSi.isChecked()){
                                text_resultado.setTextColor(Color.parseColor("#FA0000"));
                                text_resultado.setText("Incorrecto, no es bisiesto");
                            }else {
                                text_resultado.setTextColor(Color.parseColor("#FF3700B3"));
                                String text2 = "Debes marcar alguna de las dos opciones";
                                Toast toast  = Toast.makeText(context,text2,duration);
                                toast.show();
                            }
                        }

                    }
                }

            }
        });





    }

}