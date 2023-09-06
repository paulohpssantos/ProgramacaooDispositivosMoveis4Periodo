package com.example.exemploactivity;

import com.example.exemploactivity.modelo.Aluno;
import com.example.exemploactivity.modelo.Professor;

import java.util.ArrayList;

public class Controller {

    private static Controller instancia;
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Professor> listaProfessores;

    public static Controller getInstance(){
        if(instancia == null) {
            return instancia = new Controller();
        }else {
            return instancia;
        }
    }

    private Controller(){
        listaAlunos = new ArrayList<>();
        listaProfessores = new ArrayList<>();
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
}
