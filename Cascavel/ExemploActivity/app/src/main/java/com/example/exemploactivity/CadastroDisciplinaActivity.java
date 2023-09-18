package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity.modelo.Disciplina;
import com.example.exemploactivity.modelo.Professor;

import java.util.ArrayList;

public class CadastroDisciplinaActivity extends AppCompatActivity {

    private Spinner spProfessor;
    private EditText edDescDisciplina;
    private EditText edCargaHoraria;
    private TextView tvErroProfessor;
    private TextView tvListaDisciplinas;
    private Button btSalvar;
    private ArrayList<Professor> professores;
    private int posicaoSelecionado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);

        edDescDisciplina = findViewById(R.id.edDescDisciplina);
        edCargaHoraria = findViewById(R.id.edCargaHoraria);
        tvErroProfessor = findViewById(R.id.tvErroProfessor);
        tvListaDisciplinas = findViewById(R.id.tvListaDisciplinas);
        btSalvar = findViewById(R.id.btSalvar);
        spProfessor = findViewById(R.id.spProfessor);

        spProfessor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int posicao, long l) {
                if(posicao > 0) {
                    posicaoSelecionado = posicao;
                    tvErroProfessor.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDisciplina();
            }
        });

        popularListaProfessores();
        atualizarLista();

    }
    private void atualizarLista(){
        ArrayList<Disciplina> lista =
                Controller.getInstancia().retornarDisciplinas();

        String texto = "";
        for (Disciplina disciplina : lista) {
            Professor prof = disciplina.getProfessor();
            texto += disciplina.getDescricao() +"\n"+
                    "Carga horária: "+disciplina.getCargaHoraria() +" horas\n"+
                    "Professor: "+prof.getNome()+"\n"+
                    "----------------------------------------------\n";
        }
        tvListaDisciplinas.setText(texto);
    }

    private void salvarDisciplina(){
        double cargaHoraria;
        if(edDescDisciplina.getText().toString().isEmpty()){
            edDescDisciplina.setError("A descrição da disciplina deve ser informada!");
            edDescDisciplina.requestFocus();
            return;
        }
        if(edCargaHoraria.getText().toString().isEmpty()){
            edCargaHoraria.setError("A carga horaria da disciplina deve ser informada!");
            edCargaHoraria.requestFocus();
            return;
        }else{
            cargaHoraria = Double.parseDouble(edCargaHoraria.getText().toString());
            if(cargaHoraria <= 0){
                edCargaHoraria.setError("Informe uma carga horária maior que zero!");
                edCargaHoraria.requestFocus();
                return;
            }
        }
        if(posicaoSelecionado <= 0){
            tvErroProfessor.setVisibility(View.VISIBLE);
            return;
        }

        Disciplina disciplina = new Disciplina();
        disciplina.setDescricao(edDescDisciplina.getText().toString());
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setProfessor(professores.get(posicaoSelecionado-1));

        Controller.getInstancia().salvarDisciplina(disciplina);

        Toast.makeText(CadastroDisciplinaActivity.this,
                "Disciplina Cadastrada com Sucesso!",
                Toast.LENGTH_LONG).show();

    }

    public void popularListaProfessores(){
        professores = Controller.getInstancia().retornarProfessor();
        String[]vetorProfs = new String[professores.size()+1];
        vetorProfs[0] = "";
        for (int i = 0; i < professores.size(); i++) {
            Professor prof = professores.get(i);
            vetorProfs[i+1] = prof.getMatricula()+" - "+prof.getNome();
        }

        ArrayAdapter adapter = new ArrayAdapter(
                CadastroDisciplinaActivity.this,
                android.R.layout.simple_dropdown_item_1line, vetorProfs);

        spProfessor.setAdapter(adapter);
    }

}