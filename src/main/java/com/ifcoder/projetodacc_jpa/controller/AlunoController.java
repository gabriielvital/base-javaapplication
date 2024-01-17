/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.projetodacc_jpa.controller;

import com.ifcoder.projetodacc_jpa.controller.tableModel.TMCadAluno;
import com.ifcoder.projetodacc_jpa.model.dao.AlunoDAO;
import com.ifcoder.projetodacc_jpa.model.entities.Aluno;
import com.ifcoder.projetodacc_jpa.model.valid.ValidateAluno;
import java.util.List;
import javax.swing.JTable;
import com.ifcoder.projetodacc_jpa.model.exceptions.AlunoException;

/**
 *
 * @author jose
 */
public class AlunoController {

    private AlunoDAO repositorio;

    public AlunoController() {
        repositorio = new AlunoDAO();
    }

    public void cadastrarAluno(String nome, String sexo, String idade, String matricula, String anoIngresso) {
        ValidateAluno valid = new ValidateAluno();
        Aluno novoAluno = valid.validaCamposEntrada(nome, sexo, idade, matricula, anoIngresso);

        if (repositorio.findByMatricula(matricula) == null) {
            repositorio.save(novoAluno);
        } else {
            throw new AlunoException("Error - Já existe um aluno com esta 'Matricula'.");
        }
    }

    public void atualizarAluno(Long idAluno, String nome, String sexo, String idade, String matricula, String anoIngresso) {
        ValidateAluno valid = new ValidateAluno();
        Aluno novoAluno = valid.validaCamposEntrada(nome, sexo, idade, matricula, anoIngresso);
        novoAluno.setId(idAluno);
        
        repositorio.update(novoAluno);
    }

    public Aluno buscarAluno(String matricula) {
        return (Aluno) this.repositorio.findByMatricula(matricula);
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();
        
        TMCadAluno tableModel = new TMCadAluno(lst);
        grd.setModel(tableModel);        
    }
    
    public void atualizarTabela(JTable grd, String nome) {
        List lst = repositorio.filterByName(nome);

        TMCadAluno tableModel = new TMCadAluno(lst);
        grd.setModel(tableModel);
    }
    
    

    public void excluirAluno(Long id) {
        if (id != -1) {
            repositorio.delete(id);
        } else {
            throw new AlunoException("Error - Aluno inexistente.");
        }
        
    }    

}
