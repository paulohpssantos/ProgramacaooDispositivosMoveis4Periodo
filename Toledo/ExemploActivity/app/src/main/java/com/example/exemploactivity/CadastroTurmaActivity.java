package com.example.exemploactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CadastroTurmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_turma);
        setTitle("Cadastro Turma");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnInflater = getMenuInflater();
        mnInflater.inflate(R.menu.menu_padrao, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSalvar) {
            salvarTurma();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void salvarTurma() {

    }
}