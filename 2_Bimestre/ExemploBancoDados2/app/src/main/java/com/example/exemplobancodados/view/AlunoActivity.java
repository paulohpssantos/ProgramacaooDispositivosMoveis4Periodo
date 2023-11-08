package com.example.exemplobancodados.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.controller.AlunoController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AlunoActivity extends AppCompatActivity {

    private EditText edRa;
    private EditText edNome;
    private FloatingActionButton btCadastroAluno;
    private AlertDialog cadastroDialog;
    private AlunoController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        btCadastroAluno = findViewById(R.id.btCadastroAluno);
        controller = new AlunoController(this);
        btCadastroAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroAluno();
            }
        });
    }

    private void abrirCadastroAluno() {
        //Carrega o arquivo xml do layout
        View viewAlert = getLayoutInflater()
                .inflate(R.layout.dialog_cadastro_aluno, null);

        edRa = viewAlert.findViewById(R.id.edRa);
        edNome = viewAlert.findViewById(R.id.edNome);

        //Carregar os componentes do AlertDialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CADASTRO DE ALUNO"); //setando o titulo
        builder.setView(viewAlert);  //setando o layout
        builder.setCancelable(false); //impedir que feche o dialog ao clicar fora dele

        //Carregando os botões na tela
        builder.setNegativeButton("Cancelar", null);
        builder.setPositiveButton("Salvar", null);

        //Construindo o layout
        cadastroDialog = builder.create();

        //Setando ação no botão salvar
        cadastroDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button btSalvar =
                        cadastroDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                btSalvar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        salvarAluno();
                    }
                });

            }
        });
        cadastroDialog.show();

    }

    private void salvarAluno() {
        String retorno = controller.salvarAluno(edRa.getText().toString(),
                edNome.getText().toString());

        if(retorno != null){
            //setar os erros
            if(retorno.contains("RA")){
                edRa.setError(retorno);
                edRa.requestFocus();
            }else if(retorno.contains("NOME")){
                edNome.setError(retorno);
                edNome.requestFocus();
            }else{
                Toast.makeText(this, retorno, Toast.LENGTH_LONG).show();
            }


        }else{
            Toast.makeText(this,
                    "Aluno cadastrado com sucesso!",
                    Toast.LENGTH_LONG).show();
            cadastroDialog.dismiss();

        }

    }
}







