package com.example.exemploactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.exemploactivity.modelo.Aluno;

import java.util.ArrayList;

public class CadastroTurmaActivity extends AppCompatActivity {

    private AutoCompleteTextView tvAddAluno;
    private RadioButton rbAnual;
    private RadioButton rbSemestral;
    private RadioGroup rgSistema;

    private ArrayList<Aluno>listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_turma);
        setTitle("Cadastro de Turma");

        tvAddAluno = findViewById(R.id.tvAddAluno);
        rbAnual = findViewById(R.id.rbAnual);
        rbSemestral = findViewById(R.id.rbSemestral);
        rgSistema = findViewById(R.id.rgSistema);

        rgSistema.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == rbAnual.getId()){
                    //selecionou o Anual
                }else{
                    //selecionou o Semestral
                }
            }
        });

        carregarAlunos();

    }

    private void carregarAlunos(){
        listaAlunos = Controller.getInstance().retornarAlunos();
        String[]vetAluno = new String[listaAlunos.size()];
        for (int i = 0; i < listaAlunos.size(); i++) {
            Aluno aluno = listaAlunos.get(i);
            vetAluno[i] = aluno.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(CadastroTurmaActivity.this,
                android.R.layout.simple_dropdown_item_1line, vetAluno);

        tvAddAluno.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_padrao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSalvar) {//chamar o metodo de salvar
            salvarTurma();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvarTurma() {

        if(rbAnual.isChecked()){
            Toast.makeText(this,
                    "vc selecionou o Anual",
                    Toast.LENGTH_LONG).show();
        }
        if(rbSemestral.isChecked()){
            Toast.makeText(this,
                    "vc selecionou o Semestral",
                    Toast.LENGTH_LONG).show();
        }

    }
}