package com.example.exemplobancodados.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.exemplobancodados.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AlunoActivity extends AppCompatActivity {

    private FloatingActionButton btCadastroAluno;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        btCadastroAluno = findViewById(R.id.btCadastroAluno);
        btCadastroAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastro();
            }
        });
    }

    private void abrirCadastro() {
        //Carregando o arquivo xml do layout
        View view = getLayoutInflater()
                .inflate(R.layout.dialog_cadastro_aluno, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CADASTRO DE ALUNO"); //Adicionando título ao popup
        builder.setView(view); //Setando o layout
        builder.setCancelable(false); //não deixa fechar o popup se clicar fora dele

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //método de salvar aluno
            }
        });

        dialog = builder.create();
        dialog.show();

    }
}









