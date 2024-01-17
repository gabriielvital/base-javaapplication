package com.ifcoder.projetodacc_jpa.controller;

import com.ifcoder.projetodacc_jpa.controller.tableModel.TMCadDisciplina;
import com.ifcoder.projetodacc_jpa.model.dao.DisciplinaDAO;
import com.ifcoder.projetodacc_jpa.model.entities.Disciplina;
import com.ifcoder.projetodacc_jpa.model.valid.ValidateDisciplina;
import javax.swing.JTable;
import com.ifcoder.projetodacc_jpa.model.exceptions.ProfessorException;
import java.util.List;

/**
 *
 * @author jose
 */
public class DisciplinaController {

    private DisciplinaDAO repositorio;

    public DisciplinaController() {
        repositorio = new DisciplinaDAO();        
    }

    public void cadastrarDisciplina(String nome, String curso, String semestre) {
        ValidateDisciplina valid = new ValidateDisciplina();
        Disciplina novaDisciplina = valid.validaCamposEntrada(nome, curso, semestre);

        // Aqui, estou supondo que você quer evitar ter duas disciplinas com o mesmo nome.
        // Caso contrário, ajuste conforme necessário.
        if (repositorio.findByName(novaDisciplina.getNome()) != null) {
            throw new ProfessorException("Error - Já existe uma disciplina com este 'nome'.");
        } else {
            repositorio.save(novaDisciplina);
        }
    }    
    
    public void atualizarDisciplina(Long idDisciplina, String nome, String curso, String semestre) {
        ValidateDisciplina valid = new ValidateDisciplina();
        Disciplina novaDisciplina = valid.validaCamposEntrada(nome, curso, semestre);
        novaDisciplina.setId(idDisciplina);
        repositorio.update(novaDisciplina);
    }    

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        
        TMCadDisciplina tableModel = new TMCadDisciplina(lst);
        Util.jTableShow(grd, tableModel, null);
    }
    
    public void atualizarTabela(JTable grd, String nome) {
        List lst = repositorio.filterByName(nome);

        TMCadDisciplina tableModel = new TMCadDisciplina(lst);
        grd.setModel(tableModel);
    }

    public void excluirDisciplina(Long id) {     
        if (id != -1) {
            repositorio.delete(id);
        } else {
            throw new ProfessorException("Error - Disciplina inexistente.");
        }
    }
}
