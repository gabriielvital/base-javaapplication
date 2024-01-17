package com.ifcoder.projetodacc_jpa.model.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Professor extends Pessoa {

    private String cpf;
    
    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;

    public Professor() {
        super();
        this.cpf = "000.000.000-00";
    }

    public Professor(String nome, char sexo, int idade, String cpf) {
        super(nome, sexo, idade);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        String txt
                = "---------- Professor -----------\n";
        txt += super.toString();
        txt += "CPF: " + this.cpf + "\n"
                + "-------------------------------------\n";
        return txt;
    }

    @Override
    public boolean equals(Object obj) {
        Professor outro = (Professor) obj;
        if (!super.equals(obj)) {
            return false;
        } else if (this.cpf.equals(outro.getCpf())) {
            return false;
        }

        return true;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
