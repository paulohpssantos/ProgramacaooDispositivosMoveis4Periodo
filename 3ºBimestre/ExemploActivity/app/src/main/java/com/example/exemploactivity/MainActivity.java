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
    private TextView tvAlunosCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrarAluno = findViewById(R.id.btCadastroAluno);
        tvAlunosCadastrados = findViewById(R.id.tvAlunosCadastrados);

        btCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroAluno();
            }
        });
    }

    /**
     * método para abrir uma nova activity
     */
    private void abrirCadastroAluno() {
        Intent intent = new Intent(MainActivity.this,
                CadastroAlunoActivity.class);

        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String texto = "";
        for (Aluno aluno : Controller.getInstance().retornarAlunos()) {
            texto += "RA: "+aluno.getRa()+" - "+aluno.getNome()+"\n";
        }
        tvAlunosCadastrados.setText(texto);

    }
}