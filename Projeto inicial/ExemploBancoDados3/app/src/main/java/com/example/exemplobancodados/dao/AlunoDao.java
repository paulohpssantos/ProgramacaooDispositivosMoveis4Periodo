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
                "UNIPAR_BD", null, 1);

        //instanciando a base de dados
        baseDados = openHelper.getWritableDatabase();


    }

    @Override
    public long insert(Aluno obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getRa()); //RA
            valores.put(colunas[1], obj.getNome()); //NOME

            return baseDados.insert(tabela, null, valores);

//            return baseDados.execSQL("INSERT INTO ALUNO (RA, NOME) VALUES " +
//                    "("+obj.getRa()+", "+obj.getNome()+" )");

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.insert() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(Aluno obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(colunas[1], obj.getNome());

            String[]identificador = {String.valueOf(obj.getRa())};

            return baseDados.update(tabela,  valores,
                    colunas[0]+"= ?", identificador);

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.update() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Aluno obj) {
        try{
            String[]identificador = {String.valueOf(obj.getRa())};

            return baseDados.delete(tabela,
                    colunas[0]+"= ?", identificador);
        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.delete() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Aluno> getAll() {
        ArrayList<Aluno> lista = new ArrayList<>();
        try{
            Cursor cursor = baseDados.query(tabela,
                    colunas, null,
                    null, null,
                    null, colunas[0]+" desc");

            if(cursor.moveToFirst()){
                do{
                   Aluno aluno = new Aluno();
                   aluno.setRa(cursor.getInt(0));
                   aluno.setNome(cursor.getString(1));

                   lista.add(aluno);

                }while (cursor.moveToNext());
            }

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.getAll() "+ex.getMessage());
        }

        return lista;
    }

    @Override
    public Aluno getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[0]+"= ?", identificador,
                    null, null, null);

            if(cursor.moveToFirst()){
                Aluno aluno = new Aluno();
                aluno.setRa(cursor.getInt(0));
                aluno.setNome(cursor.getString(1));

                return aluno;
            }

        }catch (SQLException ex){
            Log.e("UNIPAR", "ERRO: AlunoDao.getById() "+ex.getMessage());
        }
        return null;
    }
}
