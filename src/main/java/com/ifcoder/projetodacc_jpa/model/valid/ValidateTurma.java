package com.ifcoder.projetodacc_jpa.model.valid;


import com.ifcoder.projetodacc_jpa.model.entities.Disciplina;
import com.ifcoder.projetodacc_jpa.model.entities.Professor;
import com.ifcoder.projetodacc_jpa.model.entities.Turma;
import java.util.List;

/**
 *
 * @author jose
 */
public class ValidateTurma {
    
    public Turma validaCamposEntrada(String nomeTurma, String ano, String horario, 
                                     Disciplina disciplina, Professor professor, List lstAlunos) {
        Turma turma = new Turma();

        // Validando o campo 'nomeTurma'
        if (nomeTurma == null || nomeTurma.trim().isEmpty())
            throw new RuntimeException("Error - Campo vazio: 'Nome da Turma'.");
        turma.setNome(nomeTurma);
        
        // Validando o campo 'ano'
        int anoInt = Integer.parseInt(ano);
        if (anoInt <= 0)
            throw new RuntimeException("Error - Valor inválido para 'Ano'.");
        turma.setAno(anoInt);
        
        // Validando o campo 'horario'
        if (horario == null || horario.trim().isEmpty())
            throw new RuntimeException("Error - Campo vazio: 'Horário'.");
        turma.setHorario(horario);
        
        // Validando o campo 'disciplina'
        if (disciplina == null || disciplina.getNome().trim().isEmpty())
            throw new RuntimeException("Error - Campo vazio ou inválido: 'Disciplina'.");
        turma.setDisciplina(disciplina);
        
        // Validando o campo 'professor'
        if (professor == null || professor.getNome().trim().isEmpty())
            throw new RuntimeException("Error - Campo vazio ou inválido: 'Professor'.");
        turma.setProfessor(professor);
        
        // Validando a lista de alunos
        if (lstAlunos == null || lstAlunos.isEmpty())
            throw new RuntimeException("Error - Lista de alunos vazia ou nula.");
        turma.setLstAlunos(lstAlunos);

        return turma;
    }
    
}
