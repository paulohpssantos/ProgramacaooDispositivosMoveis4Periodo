package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity.modelo.Aluno;

import java.util.ArrayList;

public class CadastroAlunoActivity extends AppCompatActivity {

    private Button btSalvar;
    private EditText edRaAluno;
    private EditText edNomeAluno;
    private TextView tvListaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        edRaAluno = findViewById(R.id.edRaAluno);
        edNomeAluno = findViewById(R.id.edNomeAluno);
        tvListaAlunos = findViewById(R.id.tvListaAlunos);
        btSalvar = findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAluno();
            }
        });

        atualizarLista();
    }

    private void salvarAluno() {
        int ra;
        if(edRaAluno.getText().toString().isEmpty()){
            edRaAluno.setError("O RA do Aluno deve ser informado!!");
            return;
        }else{
            try {
                ra = Integer.parseInt(edRaAluno.getText().toString());
            }catch (Exception ex){
                edRaAluno.setError("Informe um RA válido (somente números)!");
                return;
            }
        }
        if(edNomeAluno.getText().toString().isEmpty()){
            edNomeAluno.setError("O Nome do Aluno deve ser informado!");
            return;
        }

        Aluno aluno = new Aluno();
        aluno.setRa(ra);
        aluno.setNome(edNomeAluno.getText().toString());

        Controller.getInstancia().salvarAluno(aluno);

        Toast.makeText(CadastroAlunoActivity.this,
                "Aluno Cadastrado com Sucesso!!", Toast.LENGTH_LONG).show();

        finish();
    }

    private void atualizarLista(){
        String texto = "";
        ArrayList<Aluno> lista = Controller.getInstancia().retornarAlunos();
        for (Aluno aluno: lista) {
            texto += aluno.getRa()+" - "+aluno.getNome()+"\n";
        }
        tvListaAlunos.setText(texto);
    }
}