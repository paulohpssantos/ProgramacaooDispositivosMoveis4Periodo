package com.example.exemplobancodados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.exemplobancodados.helper.SQLiteDataHelper;
import com.example.exemplobancodados.model.Aluno;

import java.util.ArrayList;

public class AlunoDao implements IGenericDao<Aluno>{

    //Variavel responsavel por abrir conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase baseDados;

    //nome das colunas da tabela;
    private String[]colunas = {"RA", "NOME"};

    //nome da tabela
    private String tabela = "ALUNO";

    //Contexto (view)
    private Context context;

    private static AlunoDao instancia;

    public static AlunoDao getInstancia(Context context){
        if(instancia == null){
            return instancia = new AlunoDao(context);
        }else{
            return instancia;
        }
    }

    private AlunoDao(Context context){
        this.context = context;

        //Abrir a conexão com a base de dados
        openHelper = new SQLiteDataHelper(this.context,
                "UNIPAR_TOLEDO", null, 1);

        //instanciando a base de dados
        baseDados = openHelper.getWritableDatabase();


    }

    @Override
    public long insert(Aluno obj) {
        return 0;
    }

    @Override
    public long update(Aluno obj) {
        return 0;
    }

    @Override
    public long delete(Aluno obj) {
        return 0;
    }

    @Override
    public ArrayList<Aluno> getAll() {

        return null;
    }

    @Override
    public Aluno getById(int id) {
        
        return null;
    }
}
