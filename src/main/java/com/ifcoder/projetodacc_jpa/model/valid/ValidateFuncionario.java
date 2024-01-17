
package com.ifcoder.projetodacc_jpa.model.valid;

import com.ifcoder.projetodacc_jpa.model.entities.Funcionario;
import com.ifcoder.projetodacc_jpa.model.exceptions.AlunoException;

/**
 *
 * @author jose
 */
public class ValidateFuncionario {
    
    public Funcionario validaCamposEntrada(String nome, String email, String idade, String sexo){
        Funcionario funcionario = new Funcionario();
        if (nome.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'nome'.");
        funcionario.setNome(nome);
        
        if (sexo.isEmpty()) 
            throw new AlunoException("Error - Campo vazio: 'sexo'.");                
        funcionario.setSexo(sexo.charAt(0));        

        int idadeInt = 0;
        if (idade.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'idade'.");
        
        if(!idade.matches("[0-9]*"))
            throw new AlunoException("Error - Valor inválido no campo 'idade'.");
        
        idadeInt = Integer.parseInt(idade);
        funcionario.setIdade(idadeInt);    
        
        if (email.isEmpty()) 
            throw new AlunoException("Error - Campo vazio: 'email'.");                
        funcionario.setEmail(email);

        return funcionario;
    }
    
}
