package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.exemploactivity.modelo.Aluno;

public class MainActivity extends AppCompatActivity {

    private Button btCadastrarAluno;
    private Button btCadastrarProfessor;

    private Button btCadastrarDisciplina;

    private Button btCadastrarTurma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrarAluno = findViewById(R.id.btCadastroAluno);
        btCadastrarProfessor = findViewById(R.id.btCadastroProfessor);
        btCadastrarDisciplina = findViewById(R.id.btCadastroDisciplina);
        btCadastrarTurma = findViewById(R.id.btCadastroTurma);

        btCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroAlunoActivity.class);
            }
        });

        btCadastrarProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroProfessorActivity.class);
            }
        });

        btCadastrarDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroDisciplinaActivity.class);
            }
        });

        btCadastrarTurma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity(CadastroTurmaActivity.class);
            }
        });
    }

    private void abrirActivity(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this,
                activity);
        startActivity(intent);
    }


}