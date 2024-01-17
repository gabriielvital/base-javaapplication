package com.ifcoder.projetodacc_jpa.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "tipo")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    protected String nome;
    protected char sexo;
    protected int idade;

    public Pessoa() {
        this.id = -1L;
        this.nome = "";
        this.sexo = '-';
        this.idade = 0;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    } 

    @Override
    public String toString() {
        String txt = "Nome: " + this.nome +"\n"
        +"Sexo: "+ this.sexo + "\n"
        +"Idade: "+ this.idade+"\n";
        return txt;
    }   
    
    @Override
    public boolean equals(Object obj) {
        Pessoa outro = (Pessoa) obj;
        if(!this.nome.equals(outro.getNome()))
            return false;
        else if(this.idade != outro.getIdade())
            return false;
        else if(this.sexo != outro.getSexo())
            return false;
        
        return true;
    }
    
     public void copiar(Pessoa outro) {
        this.id = outro.getId();
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
    }
    
}
