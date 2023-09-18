package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity.modelo.Professor;

public class CadastroProfessorActivity extends AppCompatActivity {


    private Button btSalvar;
    private EditText edMatriculaProf;
    private EditText edNomeProf;
    private EditText edCpfProf;
    private EditText edDtNascProf;
    private EditText edDtAdmissaoProf;
    private TextView tvProfsCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor);

        btSalvar = findViewById(R.id.btSalvar);
        edMatriculaProf = findViewById(R.id.edMatriculaProf);
        edNomeProf = findViewById(R.id.edNomeProf);
        edCpfProf = findViewById(R.id.edCpfProf);
        edDtNascProf = findViewById(R.id.edDtNascProf);
        edDtAdmissaoProf = findViewById(R.id.edDtAdmissaoProf);
        tvProfsCadastrados = findViewById(R.id.tvProfsCadastrados);

        atualizarListaProfessores();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarProfessor();
            }
        });
    }

    private void salvarProfessor() {
        if(edMatriculaProf.getText().toString().isEmpty()){
            edMatriculaProf.setError("Informe a Matricula!");
            return;
        }
        if(edNomeProf.getText().toString().isEmpty()){
            edNomeProf.setError("Informe o Nome do Professor!");
            return;
        }
        if(edCpfProf.getText().toString().isEmpty()){
            edCpfProf.setError("Informe o CPF do Professor!");
            return;
        }
        if(edDtNascProf.getText().toString().isEmpty()){
            edDtNascProf.setError("Informe a Data de Nasc. do Professor!");
            return;
        }
        if(edDtAdmissaoProf.getText().toString().isEmpty()){
            edDtAdmissaoProf.setError("Informe a Data de Admissao. do Professor!");
            return;
        }
        Professor professor = new Professor();
        professor.setMatricula(Integer.parseInt(edMatriculaProf.getText().toString()));
        professor.setNome(edNomeProf.getText().toString());
        professor.setCpf(edCpfProf.getText().toString());
        professor.setDtNasc(edDtNascProf.getText().toString());
        professor.setDtAdmissao(edDtAdmissaoProf.getText().toString());

        Controller.getInstancia().salvarProfessor(professor);

        Toast.makeText(CadastroProfessorActivity.this,
                "Professor Cadastrado com Sucesso!!",
                Toast.LENGTH_LONG).show();

        this.finish();
    }

    private void atualizarListaProfessores(){
        String texto = "";
        for (Professor prof : Controller.getInstancia().retornarProfessor()) {
            texto += "Matricula: "+prof.getMatricula()+" - "+prof.getNome()+"\n"+
                    "CPF: "+prof.getCpf()+"\n" +
                    "Dt. Nasc: "+prof.getDtNasc()+"\n"+
                    "Dt. Admissão: "+prof.getDtAdmissao()+"\n" +
                    "-----------------------------------------\n";
        }
        tvProfsCadastrados.setText(texto);
    }
}