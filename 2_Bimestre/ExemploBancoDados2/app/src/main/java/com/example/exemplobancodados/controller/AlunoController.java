package com.example.exemplobancodados.controller;

import android.content.Context;

import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.model.Aluno;

import java.util.ArrayList;

public class AlunoController {

    private Context context;

    public AlunoController(Context context) {
        this.context = context;
    }

    public String salvarAluno(String ra, String nome){
        try{
            //Validar se os campos estão vazios
            if(ra.equals("") || ra.isEmpty()){
                return "Informe o RA do Aluno!";
            }
            if(nome.equals("") || nome.isEmpty()){
                return "Informe o NOME do Aluno!";
            }

            //Validar se já existe o aluno cadastrado
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
            return "Erro ao gravar Aluno.";
        }
        return null;
    }

    public ArrayList<Aluno> retornaAlunos(){
        return AlunoDao.getInstancia(context).getAll();
    }
}
