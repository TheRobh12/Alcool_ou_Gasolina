package com.cursoandroid.alcool_ou_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool,editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool   = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado     = findViewById(R.id.textResultado);
    }

    public void calcularPreco (View view) {

        //Recuperar Valores Digitados
        String precoAlcool   = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os Campos
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if ( camposValidados ) {

            //Covertendo String para Números
            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasolina = Double.parseDouble( precoGasolina );

            /* Fazer Cálculo de Menor preço
             * Se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
             * SeNão é Melhor Utilizar Álcool
             */
            Double resultado = valorAlcool / valorGasolina;
            if ( resultado >= 0.7 ) {
                textResultado.setText("Melhor Utilizar Gasolina");
            } else {
                textResultado.setText("Melhor Utilizar Álcool");
            }

        } else {
            textResultado.setText("Preencha os Preços Primeiro!");
        }
    }
    public Boolean validarCampos ( String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ) {
            camposValidados = false;
        } else if ( pGasolina == null || pGasolina.equals("") ) {
            camposValidados = false;
        }

        return camposValidados;
    }
}