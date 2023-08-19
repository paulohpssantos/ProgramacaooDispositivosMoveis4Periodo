package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edTexto;
    private Button btMudarTexto;
    private TextView tvTextoRetornado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTexto = findViewById(R.id.edTexto);
        btMudarTexto = findViewById(R.id.btMudarTexto);
        tvTextoRetornado = findViewById(R.id.tvTextoRetornado);

        btMudarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mudarTexto();
            }
        });
    }

    private void mudarTexto() {
        String texto = edTexto.getText().toString();
        tvTextoRetornado.setText(texto);
    }
}