package com.example.bafometro_a;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Float taxaAlcool = data.getFloatExtra("taxaAlcool", 0);
        String classificacao = data.getStringExtra("classificacao");

        Toast.makeText(this, "Taxa de Alcoolemia: " + taxaAlcool + "\nClassificação: " + classificacao, Toast.LENGTH_LONG).show();
    }

    public void sendData(View v) {
        /*
        * Para navegação entre telas do mesmo app utilizar a Intent abaixo.
        */
//        Intent it = new Intent(this, SecondActivity.class);
        Intent it = new Intent("BAFOMETRO");
        EditText peso = (EditText) findViewById(R.id.inputPeso);
        EditText sexo = (EditText) findViewById(R.id.inputSexo);
        EditText numCopos = (EditText) findViewById(R.id.inputNumCopos);
        EditText jejum = (EditText) findViewById(R.id.inputJejum);

        it.putExtra("peso", Float.parseFloat(peso.getText().toString()));
        it.putExtra("sexo", sexo.getText().toString());
        it.putExtra("numCopos", Integer.parseInt(numCopos.getText().toString()));
        it.putExtra("jejum", jejum.getText().toString());

        startActivityForResult(it, 1);
    }
}