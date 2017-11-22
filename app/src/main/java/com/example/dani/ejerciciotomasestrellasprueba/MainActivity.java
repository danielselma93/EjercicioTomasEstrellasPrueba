package com.example.dani.ejerciciotomasestrellasprueba;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener{
    Button cambiarFondo;
    RelativeLayout elRela;
    Button cambiarLetras;
    TextView pulsadoLargo;
    TextView oculto;
    CheckBox mostraOculto;
    RatingBar estrellas;
    TextView mostradorRating;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambiarFondo = (Button)findViewById(R.id.button);
        cambiarLetras = (Button)findViewById(R.id.button2);
        pulsadoLargo = (TextView) findViewById(R.id.textViewLargo);
        elRela= (RelativeLayout)findViewById(R.id.relaSegundo);
        oculto=(TextView)findViewById(R.id.textViewOculto);
        mostraOculto=(CheckBox)findViewById(R.id.checkBox);
        estrellas=(RatingBar)findViewById(R.id.ratingBar);
        mostradorRating=(TextView)findViewById(R.id.textViewCalcuulador);
        estrellas.setOnRatingBarChangeListener(this);
        cambiarLetras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cambiarLetras.getText()=="Letras Rojas") {
                    cambiarLetras.setTextColor(Color.RED);
                    cambiarLetras.setText("Letras grises");
                }else{
                    cambiarLetras.setTextColor(Color.BLACK);
                    cambiarLetras.setText("Letras rojas");
                }
            }
        });
        mostraOculto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oculto.setVisibility(View.VISIBLE);
            }
        });
        pulsadoLargo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Muchas gracias", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        cambiarFondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cambiarFondo.getText()=="Fondo rojo") {
                    elRela.setBackgroundColor(Color.RED);
                    cambiarFondo.setText("Fondo gris");
                }else{
                    elRela.setBackgroundColor(Color.WHITE);
                    cambiarFondo.setText("Fondo rojo");
                }
                }
        });

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        float s=0;
        s=estrellas.getRating();
        mostradorRating.setText("["+ s + "/5");
    }
}
