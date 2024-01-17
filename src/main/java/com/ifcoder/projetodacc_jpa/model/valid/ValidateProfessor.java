package com.ifcoder.projetodacc_jpa.model.valid;

import com.ifcoder.projetodacc_jpa.model.entities.Professor;
import com.ifcoder.projetodacc_jpa.model.exceptions.ProfessorException;

/**
 *
 * @author jose
 */
public class ValidateProfessor {
    
    
    public Professor validacao(String nome, String sexo, String idade, String cpf){
        Professor p = new Professor();
        if (nome.isEmpty())
            throw new ProfessorException("Error - Campo vazio: 'nome'.");
        p.setNome(nome);
        
        if (sexo.isEmpty()) 
            throw new ProfessorException("Error - Campo vazio: 'sexo'.");                
        p.setSexo(sexo.charAt(0));        

        int idadeInt = 0;
        if (idade.isEmpty())
            throw new ProfessorException("Error - Campo vazio: 'idade'.");
        
        if(!idade.matches("[0-9]*"))
            throw new ProfessorException("Error - Valor inválido no campo 'idade'.");
        
        idadeInt = Integer.parseInt(idade);
        p.setIdade(idadeInt);        

        if(cpf.isEmpty())
            throw new ProfessorException("Error - Campo vazio: 'cpf'.");
        
        ValidatePessoaFisica validCPF = new ValidatePessoaFisica();
        if(!validCPF.validaCPF(cpf))
          throw new ProfessorException("Error - CPF invalido");
        
        p.setCpf(cpf);
        
        return p;
    }
}
