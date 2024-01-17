package com.ifcoder.projetodacc_jpa.model.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Aluno extends Pessoa {

    private String matricula;
    private int anoIngresso;
    
    @ManyToMany(mappedBy = "lstAlunos")
    private List<Turma> turmas;

    public Aluno() {
        super();
        this.matricula = "00000";
        this.anoIngresso = 1900;
    }

    public Aluno(int id, String nome, char sexo, int idade, String matricula, int anoIngresso) {
        super(nome, sexo, idade);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
    }

    public void copiar(Aluno outro) {
        super.copiar(outro);
        this.matricula = outro.getMatricula();
        this.anoIngresso = outro.getAnoIngresso();
    }

    @Override
    public String toString() {
        String txt = "---- Dados do aluno ------\n"
                + "id: " + this.id + "\n"
                + super.toString()
                + " Matricula: " + this.matricula + "\n"
                + " Ano de ingresso: " + this.anoIngresso + "\n"
                + "-------------------------------------\n";

        return txt;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

}
