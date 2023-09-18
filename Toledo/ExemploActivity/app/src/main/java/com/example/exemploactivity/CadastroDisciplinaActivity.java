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

    private TextView tvListaDisciplinas;
    private TextView tvErroProfessor;
    private EditText edDescDisciplina;
    private EditText edCargaHoraria;
    private Spinner spProfessor;
    private Button btSalvar;
    private ArrayList<Professor> listaProfessores;
    private int posicaoSelecionada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);

        tvListaDisciplinas = findViewById(R.id.tvListaDisciplinas);
        tvErroProfessor = findViewById(R.id.tvErroProfessor);
        edDescDisciplina = findViewById(R.id.edDescDisciplina);
        edCargaHoraria = findViewById(R.id.edCargaHoraria);
        spProfessor = findViewById(R.id.spProfessor);
        btSalvar = findViewById(R.id.btSalvar);

        spProfessor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int posicao, long l) {
                if(posicao > 0){
                    posicaoSelecionada = posicao;
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

        carregaProfessores();
        atualizaListaDisciplinas();
    }

    private void salvarDisciplina() {
        double cargaHoraria;

        if(edDescDisciplina.getText().toString().isEmpty()){
            edDescDisciplina.setError("A descrição da disciplina deve ser informada!!");
            edDescDisciplina.requestFocus();
            return;
        }
        if(edCargaHoraria.getText().toString().isEmpty()){
            edCargaHoraria.setError("A carga horária deve ser informada!!");
            edCargaHoraria.requestFocus();
            return;
        }else{
            cargaHoraria = Double.parseDouble(edCargaHoraria.getText().toString());
            if(cargaHoraria <= 0){
                edCargaHoraria.setError("Carga Horária deve ser maior que zero!!");
                edCargaHoraria.requestFocus();
                return;
            }
        }
        if(posicaoSelecionada <= 0){
            tvErroProfessor.setVisibility(View.VISIBLE);
            return;
        }
        Professor prof = listaProfessores.get(posicaoSelecionada-1);
        Disciplina disciplina = new Disciplina();
        disciplina.setDescricao(edDescDisciplina.getText().toString());
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setProfessor(prof);

        Controller.getInstance().salvarDisciplina(disciplina);
        Toast.makeText(this,
                "Disciplina salva com sucesso!!",
                Toast.LENGTH_LONG).show();

    }

    private void carregaProfessores() {
        listaProfessores = Controller.getInstance().retornarProfessor();
        String[]vetProfs = new String[listaProfessores.size() + 1];
        vetProfs[0] = "Selecione o professor";
        for (int i = 0; i < listaProfessores.size(); i++) {
            Professor prof = listaProfessores.get(i);
            vetProfs[i+1] = prof.getMatricula()+" - "+prof.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(
                CadastroDisciplinaActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                vetProfs);

        spProfessor.setAdapter(adapter);

    }

    private void atualizaListaDisciplinas(){
        ArrayList<Disciplina> lista = Controller.getInstance().retornarDisciplinas();
        String texto = "";
        for (Disciplina dis : lista) {
            Professor prof = dis.getProfessor();
            texto += dis.getDescricao()+"\n"+
                    "Carga Hr: "+dis.getCargaHoraria()+" Hr\n"+
                    "Professor: "+prof.getNome()+"\n" +
                    "---------------------------------------------\n";
        }
        tvListaDisciplinas.setText(texto);
    }
}