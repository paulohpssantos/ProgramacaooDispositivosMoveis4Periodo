package com.example.exemplobancodados.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.model.Aluno;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void abrirCadastroAluno(View view) {

        Intent intent = new Intent(MainActivity.this,
                AlunoActivity.class);
        startActivity(intent);

    }
}