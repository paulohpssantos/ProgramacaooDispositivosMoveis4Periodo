package com.example.exemplobancodados.controller;

import android.content.Context;
import android.content.Intent;

import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.model.Aluno;

public class AlunoController {

    private Context context;

    public AlunoController(Context context) {
        this.context = context;
    }

    public String salvarAluno(String ra, String nome){
        try{
            if(ra.equals("") || ra.isEmpty()){
                return "Informe o RA do Aluno!";
            }
            if(nome.equals("") || nome.isEmpty()){
                return "Informe o NOME do Aluno!";
            }

            Aluno aluno = AlunoDao.getInstancia(context)
                    .getById(Integer.parseInt(ra));
            if(aluno != null){
                return "O RA ("+ra+") já está cadastrado!";
            }else{
                aluno = new Aluno();
                aluno.setRa(Integer.parseInt(ra));
                aluno.setNome(nome);

                AlunoDao.getInstancia(context).insert(aluno);
            }

        }catch (Exception ex){
            return "Erro ao Gravar Aluno.";
        }
        return null;
    }
}
