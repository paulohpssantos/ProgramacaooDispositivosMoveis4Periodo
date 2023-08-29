package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exemploactivity.modelo.Aluno;

public class CadastroAlunoActivity extends AppCompatActivity {

    private Button btSalvar;
    private EditText edRaAluno;
    private EditText edNomeAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        btSalvar = findViewById(R.id.btSalvar);
        edRaAluno = findViewById(R.id.edRaAluno);
        edNomeAluno = findViewById(R.id.edNomeAluno);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAluno();
            }
        });
    }

    private void salvarAluno() {
        if(edRaAluno.getText().toString().isEmpty()){
            edRaAluno.setError("Informe o RA do aluno!");
            return;
        }
        if(edNomeAluno.getText().toString().isEmpty()){
            edNomeAluno.setError("Informe o Nome do aluno!");
            return;
        }
        Aluno aluno = new Aluno();
        aluno.setRa(Integer.parseInt(edRaAluno.getText().toString()));
        aluno.setNome(edNomeAluno.getText().toString());

        Controller.getInstance().salvarAluno(aluno);

        this.finish();
    }
}