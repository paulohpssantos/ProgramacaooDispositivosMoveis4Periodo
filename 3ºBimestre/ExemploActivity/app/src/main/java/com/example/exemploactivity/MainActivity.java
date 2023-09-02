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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrarAluno = findViewById(R.id.btCadastroAluno);
        btCadastrarProfessor = findViewById(R.id.btCadastroProfessor);
        btCadastrarDisciplina = findViewById(R.id.btCadastroDisciplina);

        btCadastrarAluno.setOnClickListener(new View.OnClickListener() {
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
    }

    private void abrirCadastroDisciplina() {
        Intent intent = new Intent(MainActivity.this,
                CadastroDisciplinaActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroProfessor() {
        Intent intent = new Intent(MainActivity.this,
                CadastroProfessorActivity.class);
        startActivity(intent);
    }

    /**
     * método para abrir uma nova activity
     */
    private void abrirCadastroAluno() {
        Intent intent = new Intent(MainActivity.this,
                CadastroAlunoActivity.class);

        startActivity(intent);
    }

}