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
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR_BD",
                null, 1);
        //Carrega a BD e da permissão para escrever na tabela
        bd = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Aluno obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getRa());
            valores.put(colunas[1], obj.getNome());

            return bd.insert(nomeTabela, null, valores);

        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.insert(): "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(Aluno obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());

            String[]identificador = {String.valueOf(obj.getRa())};
            return bd.update(nomeTabela, valores,
                    colunas[0]+" = ?", identificador);


        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.update(): "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Aluno obj) {
        try{

            String[]identificador = {String.valueOf(obj.getRa())};
            return bd.delete(nomeTabela, colunas[0]+" = ?",
                    identificador);

        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.delete(): "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Aluno> getAll() {
        ArrayList<Aluno> lista = new ArrayList<>();
        try{
            Cursor cursor = bd.query(nomeTabela, colunas,
                    null, null, null,
                    null, colunas[0]);

            //Verifica se é possível retornar o ponteiro para
            // a primeira posição do cursor
            if(cursor.moveToFirst()){
                do{
                    Aluno aluno = new Aluno();
                    aluno.setRa(cursor.getInt(0));
                    aluno.setNome(cursor.getString(1));

                    lista.add(aluno);

                }while (cursor.moveToNext());
            }
        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.getAll(): "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Aluno getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = bd.query(nomeTabela, colunas,
                    colunas[0]+" = "+id, null,
                    null, null, null);

            //Verifica se é possível retornar o ponteiro para
            // a primeira posição do cursor
            if(cursor.moveToFirst()){
                Aluno aluno = new Aluno();
                aluno.setRa(cursor.getInt(0));
                aluno.setNome(cursor.getString(1));

                return aluno;
            }

        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.getById(): "+ex.getMessage());
        }

        return null;
    }
}
