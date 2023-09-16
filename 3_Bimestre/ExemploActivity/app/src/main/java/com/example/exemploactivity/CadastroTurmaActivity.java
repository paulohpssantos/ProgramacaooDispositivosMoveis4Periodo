package com.example.exemploactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class CadastroTurmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_turma);
        setTitle("Cadastro de Turma");

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
        Toast.makeText(this,
                "vc clicou no salvar!",
                Toast.LENGTH_LONG).show();
    }
}