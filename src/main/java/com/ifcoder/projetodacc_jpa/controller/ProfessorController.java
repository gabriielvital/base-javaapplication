/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcoder.projetodacc_jpa.controller;

import com.ifcoder.projetodacc_jpa.controller.tableModel.TMCadProfessor;
import com.ifcoder.projetodacc_jpa.model.dao.ProfessorDAO;
import com.ifcoder.projetodacc_jpa.model.entities.Professor;
import com.ifcoder.projetodacc_jpa.model.valid.ValidateProfessor;
import com.ifcoder.projetodacc_jpa.model.exceptions.ProfessorException;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author jose
 */
public class ProfessorController {

    private ProfessorDAO repositorio;

    public ProfessorController() {
        repositorio = new ProfessorDAO();
    }

    public void cadastrarProfessor(String nome, String sexo, String idade, String cpf) {
        ValidateProfessor valid = new ValidateProfessor();
        Professor novoProfessor = valid.validacao(nome, sexo, idade, cpf);

        if (repositorio.findByCpf(cpf) == null) {
            repositorio.save(novoProfessor);
        } else {
            throw new ProfessorException("Error - Já existe um professor com este 'CPF'.");
        }
    }

    public void atualizarProfessor(Long idProfessor, String nome, String sexo, String idade, String cpf) {
        ValidateProfessor valid = new ValidateProfessor();
        Professor novoProfessor = valid.validacao(nome, sexo, idade, cpf);
        novoProfessor.setId(idProfessor);

        repositorio.update(novoProfessor);
    }

    public Professor buscarProfessor(String cpf) {
        return this.repositorio.findByCpf(cpf);
    }

    public void excluirProfessor(Long id) {
        if (id != null) {
            repositorio.delete(id);
        } else {
            throw new ProfessorException("Error - Professor inexistente.");
        }
    }

    public void atualizarTabela(JTable grd) {
        List lst = repositorio.findAll();

        TMCadProfessor tableModel = new TMCadProfessor(lst);
        grd.setModel(tableModel);
    }

    public void atualizarTabela(JTable grd, String nome) {
        List lst = repositorio.filterByName(nome);

        TMCadProfessor tableModel = new TMCadProfessor(lst);
        grd.setModel(tableModel);
    }
    
    
}
