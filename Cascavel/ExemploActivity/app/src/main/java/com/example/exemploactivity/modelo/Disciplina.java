package com.example.exemploactivity.modelo;

public class Disciplina {

    private String descricao;
    private double cargaHoraria;
    private Professor professor;

    public Disciplina() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
