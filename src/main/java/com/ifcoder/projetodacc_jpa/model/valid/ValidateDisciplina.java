package com.ifcoder.projetodacc_jpa.model.valid;

import com.ifcoder.projetodacc_jpa.model.entities.Disciplina;


/**
 *
 * @author jose
 */
public class ValidateDisciplina {
    
    public Disciplina validaCamposEntrada(String nome, String curso, String semestre){
        Disciplina disciplina = new Disciplina();

        // Validando o campo 'nome'
        if (nome == null || nome.trim().isEmpty())
            throw new RuntimeException("Error - Campo vazio: 'nome'.");
        disciplina.setNome(nome);
        
        // Validando o campo 'curso'
        if (curso == null || curso.trim().isEmpty())
            throw new RuntimeException("Error - Campo vazio: 'curso'.");
        disciplina.setCurso(curso);
        
        // Validando o campo 'semestre'
        if (semestre == null || semestre.trim().isEmpty())
            throw new RuntimeException("Error - Campo vazio: 'semestre'.");
        disciplina.setSemestre(semestre);

        return disciplina;
    }
    
}

