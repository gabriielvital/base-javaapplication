package com.ifcoder.projetodacc_jpa.controller;

import com.ifcoder.projetodacc_jpa.controller.tableModel.TMAlunoTurma;
import com.ifcoder.projetodacc_jpa.controller.tableModel.TMTurma;
import com.ifcoder.projetodacc_jpa.model.dao.TurmaDAO;
import com.ifcoder.projetodacc_jpa.model.entities.Aluno;
import com.ifcoder.projetodacc_jpa.model.entities.Disciplina;
import com.ifcoder.projetodacc_jpa.model.entities.Professor;
import com.ifcoder.projetodacc_jpa.model.entities.Turma;
import com.ifcoder.projetodacc_jpa.model.exceptions.ProfessorException;
import com.ifcoder.projetodacc_jpa.model.valid.ValidateTurma;
import javax.swing.JTable;
import java.util.List;

/**
 *
 * @author jose
 */
public class TurmaController {

    private TurmaDAO repositorio;

    public TurmaController() {
        repositorio = new TurmaDAO();        
    }

     public void cadastrarTurma(String nomeTurma, String ano, String horario, 
                               Disciplina disciplina, Professor professor, List<Aluno> lstAlunos) {

        ValidateTurma valid = new ValidateTurma();
        Turma novaTurma = valid.validaCamposEntrada(nomeTurma, ano, horario, disciplina, professor, lstAlunos);
        
         repositorio.save(novaTurma);
         
         //Aqui podemos verificar ja existe uma mesma turma para uma mesma disciplina,
         //para um mesmo ano e etc. 
         //Assim vemos claramente nosso controller com muita regra de negócio e portanto, sugere
         //a criação de uma camada a mais (SERVICO)
        
//        Turma turmaExistente = repositorio.findByName(nomeTurma);
//                                                           
//        if (turmaExistente != null) {
//            throw new RuntimeException("Erro - Já existe uma turma com este nome.");
//        } else {
//            repositorio.save(novaTurma);
//        }
    }

    public void atualizarTurma(Long idTurma, String nomeTurma, String ano, String horario, 
                               Disciplina disciplina, Professor professor, List<Aluno> lstAlunos) {

        ValidateTurma valid = new ValidateTurma();
        Turma novaTurma = valid.validaCamposEntrada(nomeTurma, ano, horario, disciplina, professor, lstAlunos);
        novaTurma.setId(idTurma);
        
        repositorio.update(novaTurma);
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        TMTurma tableModel = new TMTurma(lst);
        Util.jTableShow(grd, tableModel, null); // Supondo que exista algo similar ao TMCadFuncionario para Turma.
    }
    
    /**
     Este é usado para atualizar a lista de alunos de uma turma
     */
    public void atualizarTabelaAlunoTurma(JTable grd, List<Aluno> lst) {
        TMAlunoTurma tableModel = new TMAlunoTurma(lst);
        grd.setModel(tableModel);        
    }

    public void excluirTurma(Long id) {                
        if (id != null) {
            repositorio.delete(id);
        } else {
            throw new ProfessorException("Erro - Turma inexistente.");
        }
    }

    public List<Turma> filtrarPorAno(int ano) {
        return repositorio.filterByYear(ano);
    }
}

