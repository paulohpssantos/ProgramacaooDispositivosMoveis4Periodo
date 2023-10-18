package com.example.exemplobancodados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.exemplobancodados.helper.SQLiteDataHelper;
import com.example.exemplobancodados.model.Aluno;

import java.util.ArrayList;

public class AlunoDao implements GenericDao<Aluno>{

    //Variavel para abrir a conexão com BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase bd;

    //Nome da tabela
    private String nomeTabela = "ALUNO";

    //Nome das colunas da tabela
    private String[]colunas = {"RA", "NOME"};

    private Context context;

    private static AlunoDao instancia;

    public static AlunoDao getInstancia(Context context){
        if(instancia == null){
            return instancia = new AlunoDao(context);
        }else{
            return instancia;
        }
    }

    private AlunoDao(Context context) {
        this.context = context;

        //Abrir uma conexão da BD
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR_CVEL",
                null, 1);
        //Carrega a BD e da permissão para escrever na tabela
        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Aluno obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("RA", obj.getRa());
            valores.put("NOME", obj.getNome());

            return bd.insert(nomeTabela, null, valores);

        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.insert(): "+ex.getMessage());
        }
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
