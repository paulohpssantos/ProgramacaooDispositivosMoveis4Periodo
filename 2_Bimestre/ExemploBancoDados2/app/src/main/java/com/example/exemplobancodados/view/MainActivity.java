package com.example.exemplobancodados.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.model.Aluno;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aluno aluno = new Aluno();
        aluno.setRa(123);
        aluno.setNome("JUCA");
        AlunoDao.getInstancia(this).insert(aluno);

    }
}