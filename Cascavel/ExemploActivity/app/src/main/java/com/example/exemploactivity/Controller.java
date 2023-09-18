package com.example.exemploactivity;

import com.example.exemploactivity.modelo.Aluno;
import com.example.exemploactivity.modelo.Disciplina;
import com.example.exemploactivity.modelo.Professor;

import java.util.ArrayList;
import java.util.Dictionary;

public class Controller {

    private static Controller instancia;
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Professor> listaProfessores;
    private ArrayList<Disciplina> listaDisciplinas;

    public static Controller getInstancia(){
        if(instancia == null) {
            return instancia = new Controller();
        }else {
            return instancia;
        }
    }

    private Controller(){
        listaAlunos = new ArrayList<>();
        listaProfessores = new ArrayList<>();
        listaDisciplinas = new ArrayList<>();
    }

    public void salvarAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    public ArrayList<Aluno> retornarAlunos() {
        return listaAlunos;
    }
    public void salvarProfessor(Professor professor){
        listaProfessores.add(professor);
    }

    public ArrayList<Professor> retornarProfessor() {
        return listaProfessores;
    }

    public void salvarDisciplina(Disciplina disciplina){
        listaDisciplinas.add(disciplina);
    }

    public ArrayList<Disciplina>retornarDisciplinas(){
        return  listaDisciplinas;
    }
}

