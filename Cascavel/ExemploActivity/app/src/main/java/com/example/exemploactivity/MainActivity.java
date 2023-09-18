package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btCadastroAluno;
    private Button btCadastrarProfessor;
    private Button btCadastrarDisciplina;
    private Button btCadastroTurma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastroAluno = findViewById(R.id.btCadastroAluno);
        btCadastrarProfessor = findViewById(R.id.btCadastroProfessor);
        btCadastrarDisciplina = findViewById(R.id.btCadastroDisciplina);
        btCadastroTurma = findViewById(R.id.btCadastroTurma);

        btCadastroAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroAluno();
            }
        });

        btCadastrarProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroProfessor();
            }
        });
        btCadastrarDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroDisciplina();
            }
        });

        btCadastroTurma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroTurma();
            }
        });

    }

    private void abrirCadastroTurma() {
        Intent intent = new Intent(MainActivity.this,
                CadastroTurmasActivity.class);

        startActivity(intent);
    }

    private void abrirCadastroDisciplina() {
        Intent intent = new Intent(MainActivity.this,
                CadastroDisciplinaActivity.class);

        startActivity(intent);
    }

    private void abrirCadastroAluno() {
        Intent intent = new Intent(MainActivity.this,
                CadastroAlunoActivity.class);

        startActivity(intent);
    }

    private void abrirCadastroProfessor() {
        Intent intent = new Intent(MainActivity.this,
                CadastroProfessorActivity.class);
        startActivity(intent);
    }

}