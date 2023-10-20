package com.example.exemplobancodados.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.dao.AlunoDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlunoDao.getInstancia(this);
    }
}